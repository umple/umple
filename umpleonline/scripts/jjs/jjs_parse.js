var JJSdiagram = {

	paper: null,
	container: null,
	// model represents the JSON model
	JSONmodel: null,
	diagram_type: null,

	initJJSDiagram: function(container, model) {

		this.container = container;
		this.JSONmodel = model;

		// Modifying the JointJS uml.Class prototpye to add the icon indicating presence of state machines.
		joint.shapes.uml.Class.prototype.markup = ['<g class="rotatable">',
							'<g class="scalable">',
							'<rect class="uml-class-name-rect"/><rect class="uml-class-attrs-rect"/><rect class="uml-class-methods-rect"/>',
							'</g>',
							'<rect class="sm-icon"/><text class="uml-class-name-text"/><text class="uml-class-attrs-text"/><text class="uml-class-methods-text"/>',
							'</g>'
							].join('');

		container.html('<div id="jjsPaper"></div>');

		var graph = new joint.dia.Graph;

		// Start by making the paper an arbitrary size; it will later be re-scaled to fit the model
		this.paper = new joint.dia.Paper({
			el: jQuery("#jjsPaper"),
			width: 100,
			height: 100,
			model: graph,
			gridSize: 1,
			padding: 15
		});

		this.makeUMLclassDiagram();

		JJSdiagram.setPaperListener();

		return this.paper;
	},

	setPaperListener: function() {
		this.paper.on('cell:pointerdown', 
			function(cellView, evt, x, y) { 
				if (JJSdiagram.diagram_type === "UMLclass") {
					var cellPosition = cellView.model.get('position');
					// Make sure the user has clicked on a cellView (and not a transition)
					if (cellPosition !== undefined) {
						// Determine if user has clicked on the state-machine icon
						if (x - cellPosition.x < 18 && y - cellPosition.y < 18) {
							// We recycle the JJSdiagram.paper by clearing out the current cells 
							// and re-populating it with the state-machine cells.
							var cellsToRemove = JJSdiagram.paper.model.getCells();
							JJSdiagram.paper.model.removeCells(cellsToRemove);

							JJSdiagram.makeUMLstateDiagram(cellView.model.id);
						}
					}
				}
				// else JJSdiagram.diagram_type === "UMLstate"
				else {
					if (cellView.model.id === "back_button") {
						// Recycling the paper
						var cellsToRemove = JJSdiagram.paper.model.getCells();
						JJSdiagram.paper.model.removeCells(cellsToRemove);

						// Resetting the origin change made in makeUMLstateDiagram
						JJSdiagram.paper.setOrigin(0, 0);

						JJSdiagram.makeUMLclassDiagram();
					}
				}
			}
		);	
	},

	makeUMLclassDiagram: function() {

		this.diagram_type = "UMLclass";

		JJSdiagram.paper.model.addCells(this.JJsParse.makeClasses(this.JSONmodel));
		JJSdiagram.paper.model.addCells(this.JJsParse.makeAssociations(this.JSONmodel));
		JJSdiagram.paper.model.addCells(this.JJsParse.makeGeneralizationLinks(this.JSONmodel));
		JJSdiagram.paper.model.addCells(this.JJsParse.makeInterfaceLinks(this.JSONmodel));

		var bbox = JJSdiagram.paper.model.getBBox(JJSdiagram.paper.model.getElements());
		// This occurs when no model has been loaded.
		if (bbox !== null) {
			// Resize the paper to fit all of the cells.
			this.paper.setDimensions(Math.max(bbox.width + 100, this.container.width()), Math.max(bbox.height + 100, this.container.height()));
		}

		// Sort out the overlapping associations
		JJSdiagram.paper.model.getCells().forEach(function(cell) {
			JJSdiagram.JJsUtils.adjustVertices(JJSdiagram.paper.model,cell);
		});
	},

	makeUMLstateDiagram: function(UMLclassName) {
		this.diagram_type = "UMLstate";

		var class_sms = _.find(JJSdiagram.JSONmodel.umpleClasses, { "name": UMLclassName }).stateMachines;

		// Only set up for a single top-level state machine
		var graph_cells = JJSdiagram.JJsParse.parseStateMachine(class_sms[0]);

		// Make the back button and add it to the graph
		var back = new joint.shapes.uml_state_machine.BackButton({
			position: { x: 0, y: 0},
			size: {width: 100, height: 40},
			id: "back_button"
		});
		JJSdiagram.paper.model.addCell(back);

		// Auto-layout the model.
		joint.layout.DirectedGraph.layout(JJSdiagram.paper.model, { setLinkVertices: false });

		// Add the last states and transitions to the graph, after making the list FILO.
		JJSdiagram.JJsParse.notYetAddedStatesStack.reverse()
		JJSdiagram.JJsParse.notYetAddedStatesStack.forEach(function(cell) {
			cell.doEmbed(JJSdiagram.paper);
			cell.updateRectangles(JJSdiagram.paper);
		});
		JJSdiagram.paper.model.addCells(JJSdiagram.JJsParse.notYetAddedStatesStack);
		JJSdiagram.paper.model.addCells(JJSdiagram.JJsParse.notYetAddedTransitionsStack);

		// Reset the stacks, or see these entities show up in other diagrams.
		JJSdiagram.JJsParse.notYetAddedStatesStack = [];
		JJSdiagram.JJsParse.notYetAddedTransitionsStack = [];

		// Sort out overlapping transitions
		JJSdiagram.paper.model.getCells().forEach(function(cell) {
			JJSdiagram.JJsUtils.adjustVertices(JJSdiagram.paper.model,cell);
		});

		// Because the auto-layout squeezes the diagram towards the left-hand side.
		JJSdiagram.paper.setOrigin(100, 50);

		var bbox = JJSdiagram.paper.model.getBBox(JJSdiagram.paper.model.getElements());
		// This occurs when no model has been loaded.
		if (bbox !== null) {
			// Resize the paper to fit all of the cells, plus some breathing room.
			this.paper.setDimensions(Math.max(bbox.width + 200, this.container.width()), Math.max(bbox.height + 150, this.container.height()));
		}
	},

	JJsUtils: {

		// from JointJS tutorial: http://resources.jointjs.com/tutorial/multiple-links-between-elements
		adjustVertices: function (graph, cell) {

			// If the cell is a view, find its model.
			cell = cell.model || cell;

			if (cell instanceof joint.dia.Element) {

				_.chain(graph.getConnectedLinks(cell)).groupBy(function(link) {
					// the key of the group is the model id of the link's source or target, but not our cell id.
					return _.omit([link.get('source').id, link.get('target').id], cell.id)[0];
				}).each(function(group, key) {
					// If the member of the group has both source and target model adjust vertices.
					if (key !== 'undefined') adjustVertices(graph, _.first(group));
				});

				return;
			}

			// The cell is a link. Let's find its source and target models.
			var srcId = cell.get('source').id || cell.previous('source').id;
			var trgId = cell.get('target').id || cell.previous('target').id;

			// If one of the ends is not a model, the link has no siblings.
			if (!srcId || !trgId) return;

			var siblings = _.filter(graph.getLinks(), function(sibling) {

				var _srcId = sibling.get('source').id;
				var _trgId = sibling.get('target').id;

				return (_srcId === srcId && _trgId === trgId) || (_srcId === trgId && _trgId === srcId);
			});

			switch (siblings.length) {

			case 0:
				// The link was removed and had no siblings.
				break;

			case 1:
				// There is only one link between the source and target. No vertices needed.

				// Have commented this out, as the positive benefits are unknown,
				//   but it certainly breaks the work established to make generalization links and self-referential associations
				// cell.unset('vertices');
				break;

			default:

				// There is more than one siblings. We need to create vertices.

				// First of all we'll find the middle point of the link.
				var srcCenter = graph.getCell(srcId).getBBox().center();
				var trgCenter = graph.getCell(trgId).getBBox().center();
				var midPoint = g.line(srcCenter, trgCenter).midpoint();

				// Then find the angle it forms.
				var theta = srcCenter.theta(trgCenter);

				// This is the maximum distance between links
				var gap = 20;

				_.each(siblings, function(sibling, index) {

					// We want the offset values to be calculated as follows 0, 20, 20, 40, 40, 60, 60 ..
					var offset = gap * Math.ceil(index / 2);

					// Now we need the vertices to be placed at points which are 'offset' pixels distant
					// from the first link and forms a perpendicular angle to it. And as index goes up
					// alternate left and right.
					//
					//  ^  odd indexes 
					//  |
					//  |---->  index 0 line (straight line between a source center and a target center.
					//  |
					//  v  even indexes
					var sign = index % 2 ? 1 : -1;
					var angle = g.toRad(theta + sign * 90);

					// We found the vertex.
					var vertex = g.point.fromPolar(offset, angle, midPoint);

					sibling.set('vertices', [{ x: vertex.x, y: vertex.y }]);
				});
			}
		}
	},

	JJsParse: {

		addAttributes: function (attrs) {
			// { "type" : "String", "name" : "startTime", "modifier" : "", "traceColor" : "black" }
			var attributes = new Array();

			var parseAttributes = function (attribute) {
				var text = JJSdiagram.JJsParse.makeModifier(attribute.modifier) + " " + attribute.name + ": " + attribute.type;
				attributes.push(text);
			};

			attrs.forEach(parseAttributes);

			// If there are no attributes, then reveal their absence
			if (attributes.length == 0 && Page.showAttributes) {
				attributes.push(" ");
			}

			return attributes;
		},

		addMethods: function(meths) {
			// {type: "void", name: "setDoorTimer", parameters: "Integer", visibility: "public", isAbstract: "false"}
			var methods = new Array();

			var parseMethods = function (method) {
				var text =  JJSdiagram.JJsParse.makeModifier(method.visibility) + " " + method.name + "(" + method.parameters + ") : " + method.type;
				methods.push(text);  
			};

			meths.forEach(parseMethods);

			// If there are no methods, then reveal their absence
			if (methods.length == 0 && Page.showMethods) {
				methods.push(" ");
			}

			return methods;
		},

		makeModifier: function(modifier) {
			var symbol = "";
			switch (modifier) {
				case "public":
					symbol = "+";
					break;
				case "package":
					symbol = "~";
					break;
				case "protected":
					symbol = "#";
					break;
				case "private":
					symbol = "-";
					break;
				default:
					symbol = "-";
				}
			return symbol;
		},

	    updateRectangles: function(UMLclass) {

	        var attrs = UMLclass.get('attrs');

	        var rects = [
	            { type: 'name', text: UMLclass.getClassName() },
	            { type: 'attrs', text: UMLclass.get('attributes') },
	            { type: 'methods', text: UMLclass.get('methods') }
	        ];

	        var offsetY = 0, maxWidth = UMLclass.attributes.size.width;

	        _.each(rects, function(rect) {

	            var lines = _.isArray(rect.text) ? rect.text : [rect.text];
	            var rectHeight = lines[0] != null ? lines.length * 9 + 10 : 0;

		        // Calculate the longest attribute or method string
	            lines.forEach(function(line) {
	            	if (line !== null) {
		            	if (line.length * 4 > maxWidth) {
		            		maxWidth = line.length * 4;
		            	}	            		
	            	}
	            });

	            attrs['.uml-class-' + rect.type + '-text'].text = lines.join('\n');
	            attrs['.uml-class-' + rect.type + '-rect'].height = rectHeight;
	            attrs['.uml-class-' + rect.type + '-rect'].transform = 'translate(0,' + offsetY + ')';

	            offsetY += rectHeight;
	        });

	        // Now resize the parent SVG to offsetY and the longest string
	        var current_size = UMLclass.attributes.size;
	        UMLclass.resize(maxWidth, offsetY);
	    },

		makeClasses: function (model) {

			var classes = new Array();

			var instantiate = function(UMLclass) {
				var new_class;

				if (UMLclass.isAbstract === "true") {
					new_class = new joint.shapes.uml.Abstract({
						position: UMLclass.position,
						size: UMLclass.position,
						name: [UMLclass.name],
						attributes: JJSdiagram.JJsParse.addAttributes(UMLclass.attributes),
						methods: JJSdiagram.JJsParse.addMethods(UMLclass.methods),
						id: UMLclass.id
					});
				}
				else if (UMLclass.isInterface === "true") {
					new_class = new joint.shapes.uml.Interface({
						position: UMLclass.position,
						size: UMLclass.position,
						name: [UMLclass.name],
						attributes: JJSdiagram.JJsParse.addAttributes(UMLclass.attributes),
						methods: JJSdiagram.JJsParse.addMethods(UMLclass.methods),
						id: UMLclass.id
					});
					// Assign default Interface colours if not already assigned
					if (UMLclass.displayColor === "") {
						new_class.attr( {'.uml-class-name-rect': { 'stroke': 'black', 'stroke-width': 2, 'fill': '#eed3d3' },
							'.uml-class-attrs-rect': { 'stroke': 'black', 'stroke-width': 2, 'fill': '#ffe3e3' },
							'.uml-class-methods-rect': { 'stroke': 'black', 'stroke-width': 2, 'fill': '#ffe3e3' } });
						UMLclass.displayColor = "assigned";
					}
				}
				else {
					var hasStateMachine = false;
					if (UMLclass.stateMachines.length > 0) {
						hasStateMachine = true;
					}
					new_class = new joint.shapes.uml.Class({
						position: UMLclass.position,
						size: UMLclass.position,
						name: [UMLclass.name],
						attributes: Page.showAttributes ? JJSdiagram.JJsParse.addAttributes(UMLclass.attributes) : null,
						methods: Page.showMethods ? JJSdiagram.JJsParse.addMethods(UMLclass.methods) : null,
						id: UMLclass.id
					});

					if (hasStateMachine) {
						new_class.attr( {'.sm-icon': {'width': 13, 'height': 13	, 'fill': '#ff0000', 'transform': 'translate(3, 3)'}});
					}

				}

				// Update all class views to properly fit the contained text strings.
				new_class.attr( {'.uml-class-attrs-text': { 'font-size': '7pt' },
								'.uml-class-methods-text': { 'font-size': '7pt'} });
				JJSdiagram.JJsParse.updateRectangles(new_class);

				switch (UMLclass.displayColor) {

					case "lightblue":
						new_class.attr( {'.uml-class-name-rect': { 'stroke': 'black', 'stroke-width': 2, 'fill': '#a1e9d9' },
							'.uml-class-attrs-rect': { 'stroke': 'black', 'stroke-width': 2, 'fill': '#b1f9e9' },
							'.uml-class-methods-rect': { 'stroke': 'black', 'stroke-width': 2, 'fill': '#b1f9e9' } });
						break;

					case "lightgreen":
						new_class.attr( {'.uml-class-name-rect': { 'stroke': 'black', 'stroke-width': 2, 'fill': '#63f788' },
							'.uml-class-attrs-rect': { 'stroke': 'black', 'stroke-width': 2, 'fill': '#73f798' },
							'.uml-class-methods-rect': { 'stroke': 'black', 'stroke-width': 2, 'fill': '#73f798' } });
						break;

					case "pink":
						new_class.attr( {'.uml-class-name-rect': { 'stroke': 'black', 'stroke-width': 2, 'fill': '#ffbac9' },
							'.uml-class-attrs-rect': { 'stroke': 'black', 'stroke-width': 2, 'fill': '#ffcad9' },
							'.uml-class-methods-rect': { 'stroke': 'black', 'stroke-width': 2, 'fill': '#ffcad9' } });
						break;

					case "lightgrey":
						new_class.attr( {'.uml-class-name-rect': { 'stroke': 'black', 'stroke-width': 2, 'fill': '#eaeaea' },
							'.uml-class-attrs-rect': { 'stroke': 'black', 'stroke-width': 2, 'fill': '#fafafa' },
							'.uml-class-methods-rect': { 'stroke': 'black', 'stroke-width': 2, 'fill': '#fafafa' } });
						break;

					case "":
						new_class.attr( {'.uml-class-name-rect': { 'stroke': 'black', 'stroke-width': 2, 'fill': '#eaeaea' },
							'.uml-class-attrs-rect': { 'stroke': 'black', 'stroke-width': 2, 'fill': '#fafafa' },
							'.uml-class-methods-rect': { 'stroke': 'black', 'stroke-width': 2, 'fill': '#fafafa' } });
						break;

					case "assigned":
						break;

					default:
						new_class.attr( {'.uml-class-name-rect': { 'stroke': 'black', 'stroke-width': 2, 'fill': UMLclass.displayColor },
							'.uml-class-attrs-rect': { 'stroke': 'black', 'stroke-width': 2, 'fill': UMLclass.displayColor },
							'.uml-class-methods-rect': { 'stroke': 'black', 'stroke-width': 2, 'fill': UMLclass.displayColor } });
				}

				classes.push(new_class);
			};

			var findGeneralizations = function (UMLclass) {
				if (UMLclass.extendsClass !== undefined) {
					if (UMLclass.extendsClass !== "") {
						var generalization = {
							source: { id: UMLclass.id },
							target: { id: UMLclass.extendsClass }
						};
					model.generalizationLinks.push(generalization);
					}
				}
			};

			var findInterfaces = function (UMLclass) {
				if (UMLclass.implementedInterfaces !== undefined) {
					if (UMLclass.implementedInterfaces !== []) {
						UMLclass.implementedInterfaces.forEach( function (each) {
							var interfaceLink = {
								source: { id: UMLclass.id },
								target: { id: each.interfacesName }
							};
							model.interfaceLinks.push(interfaceLink);
						});
					}
				}
			};

			var findAbstracts = function (UMLclass) {
				if (UMLclass.isAbstract === "true") {
					// TODO: determine the pattern from an actual example
					console.log(">>>>>>>>>>>>>>> found an ABSTRACT");
				}
			};

			model.umpleClasses.forEach(instantiate);
			model.generalizationLinks = new Array();;
			model.umpleClasses.forEach(findGeneralizations);
			model.interfaceLinks = new Array();;
			model.umpleClasses.forEach(findInterfaces);
			model.umpleClasses.forEach(findAbstracts);

			return classes;
		},

		makeAssociations: function(model) {
			var associations = new Array();

			var setPathVertices = function(source, target) {
				if (source === target) {
					var cell = JJSdiagram.paper.model.getCell(source);
					// example: {x: 255, y: 316, width: 181, height: 74, bbox: function, ...
					var cellBBox = JJSdiagram.paper.findViewByModel(cell).getBBox();
					// example: {x: 336, y: 89.5, adhereToRect: function, ...
					var cellCenter = cellBBox.center();

					var point1 = {
						x: cellCenter.x - (cellBBox.width / 2) - 25,
						y: cellCenter.y + 15
					};
					var point3 = {
						x: cellCenter.x - 20,
						y: cellCenter.y + (cellBBox.height / 2) + 25
					};
					var point2 = {
						x: point1.x,
						y: point3.y
					};

					return [point1, point2, point3];
				} 
				else {
					return [];
				}
			};

			var instantiate = function (UMLassoc) {
				var new_assoc;

				var assoc_name = UMLassoc.roleOne || UMLassoc.roleTwo;

				if (UMLassoc.isRightComposition === "true" || UMLassoc.isLeftComposition === "true") {
					new_assoc = new joint.shapes.uml.Composition({
				        source: { id: (UMLassoc.isRightComposition === "true") ? UMLassoc.classOneId : UMLassoc.classTwoId },
				        target: { id: (UMLassoc.isLeftComposition === "true")  ? UMLassoc.classOneId : UMLassoc.classTwoId },
				        labels: [
				        { position: .5, attrs: { text: { text: assoc_name || '', 'font-size': '8pt'} } },
				        { position: .05, attrs: { text: { text: UMLassoc.multiplicityOne || '', 'font-size': '8pt' }, rect: { 'fill-opacity': '0.6'} } },
				        { position: .95, attrs: { text: { text: UMLassoc.multiplicityTwo || '', 'font-size': '8pt'}, rect: { 'fill-opacity': '0.6'} } }
				        ],
						vertices: setPathVertices(UMLassoc.classOneId, UMLassoc.classTwoId)
		                // [{x: 0,y: 100}, {x: -100, y: 0}]
					});

					new_assoc.attr('.marker-target', { d: 'M 20 5 L 10 10 L 0 5 L 10 0 z', fill: 'black' });
				}
				else {
					new_assoc = new joint.shapes.uml.Association({
				        source: { id: UMLassoc.classOneId },
				        target: { id: UMLassoc.classTwoId },
				        labels: [
				        { position: .5, attrs: { text: { text: assoc_name || '', 'font-size': '8pt'} } },
				        { position: .05, attrs: { text: { text: UMLassoc.multiplicityOne || '', 'font-size': '8pt' }, rect: { 'fill-opacity': '0.6'} } },
				        { position: .95, attrs: { text: { text: UMLassoc.multiplicityTwo || '', 'font-size': '8pt'}, rect: { 'fill-opacity': '0.6'} } }
				        ],
						vertices: setPathVertices(UMLassoc.classOneId, UMLassoc.classTwoId)
		                // [{x: 0,y: 100}, {x: -100, y: 0}]
					});

					if (UMLassoc.isLeftNavigable == "true" && UMLassoc.isRightNavigable == "false") {
						new_assoc.attr('.marker-source', { d: 'M 15 0 L 0 7.5 L 15 15', fill: 'white' });
					}
					else if (UMLassoc.isLeftNavigable == "false" && UMLassoc.isRightNavigable == "true") {
						new_assoc.attr('.marker-target', { d: 'M 15 0 L 0 7.5 L 15 15', fill: 'white' });
					}

			        // Can get rid of this once the CSS bugs are fixed
					new_assoc.attr({ '.connection-wrap': {fill: 'none'}, '.connection': {fill: 'none'} });
				}

				associations.push(new_assoc);
			};

			model.umpleAssociations.forEach(instantiate);

			return associations;
		},

		makeGeneralizationLinks: function (model) {
			var generalizationLinks = new Array();

			var setPathVertices = function (source, target) {
				var sourceCell = JJSdiagram.paper.model.getCell(source);
				var targetCell = JJSdiagram.paper.model.getCell(target);
				var sourceCellBBox = JJSdiagram.paper.findViewByModel(sourceCell).getBBox();
				var targetCellBBox = JJSdiagram.paper.findViewByModel(targetCell).getBBox();

				var point1 = {
					x: sourceCellBBox.center().x,
					y: targetCellBBox.y + targetCellBBox.height + 25
				};
				var point2 = {
					x: targetCellBBox.center().x,
					y: targetCellBBox.y + targetCellBBox.height + 25
				};

				return [point1, point2];
			}

			var instantiate = function (UMLgeneralization) {
				UMLgeneralization.vertices = setPathVertices(UMLgeneralization.source.id, UMLgeneralization.target.id);
				var new_generalization = new joint.shapes.uml.Generalization(UMLgeneralization)

				new_generalization.attr({ '.connection-wrap': {fill: 'none'},
										  '.connection': {fill: 'none'},
										  '.marker-target': { d: 'M 10 0 L 0 5 L 10 10 z', fill: 'white' }});

				generalizationLinks.push(new_generalization);
			}

			model.generalizationLinks.forEach(instantiate);

			return generalizationLinks;
		},

		makeInterfaceLinks: function (model) {
			var interfaceLinks = new Array();

			var instantiate = function (UMLinterface) {
				var new_interface = new joint.shapes.uml.Implementation(UMLinterface)

				new_interface.attr({'.marker-target': { d: 'M 10 0 L 0 5 L 10 10 z', fill: 'white' },
       						        '.connection': { 'stroke-dasharray': '3,3' }});

				interfaceLinks.push(new_interface);
			}

			model.interfaceLinks.forEach(instantiate);

			return interfaceLinks;
		},

		/* 
			To make nested state machines work, there must be a certain order of operations:
			1. Instantiate all sub-state trees (lowest level), and add those states to the graph.
			2. Instantiate all of the transitions within those sub-state trees and add them to the graph.
			3. Perform the auto-layout operation on the current graph (a forest of sub-state-machines).
			4. Add the parent states, level by level, and add them to the graph.
			5. Add all remaining transitions.
			X. Ideally, each additional level of the state machine tree would have an auto-layout operation performed on it. 
		*/

		notYetAddedStatesStack: [],

		notYetAddedTransitionsStack: [],

		parseStateMachine: function(sm) {

			var instantiateState = function(state) {
				var cell;
				var composite = false;

				if (state.isfinal == true) {
					cell = new joint.shapes.uml_state_machine.FinalState({ 
						attrs: { text : { text: state.name }},
						id: state.name
					});
					JJSdiagram.paper.model.addCell(cell);
				}
				else if (state.stateMachines.length > 0) {
					// Pass each nested machine for parsing.
					state.stateMachines.forEach(JJSdiagram.JJsParse.parseStateMachine);
					// Get the names of all nested states (direct children only).
					var nestedStates = [];
					state.stateMachines.forEach(function(sm) {
						sm.states.forEach(function(s) {
							nestedStates.push(s.name);
						});
					});
					state.nestedStates = nestedStates;

					cell = new joint.shapes.uml_state_machine.CompositeState(state);
					// Then push that state's cell onto the stack
					JJSdiagram.JJsParse.notYetAddedStatesStack.push(cell);
					composite = true;
				}
				else {
					cell = new joint.shapes.uml_state_machine.State(state);
					JJSdiagram.paper.model.addCell(cell);
				}

				if (state.isstart == true) {
					// Create a new pseudo-start state
					var ps_name = "pseudo_start_" + state.name;
					var ps = new joint.shapes.uml_state_machine.PseudoStart({ id: ps_name});
					JJSdiagram.paper.model.addCell(ps);

					// Create the transistion from pseudo-start to starting state.
					var link = new joint.shapes.uml_state_machine.Transition({
						source: { id: ps_name },
						target: { id: cell.id },
						labels: [{ position: .5, attrs: { text: { text: 'start', 'font-weight': 'bold', 'font-size': 9 } } }],
						attrs: { '.connection-wrap': {fill: 'none'}, '.connection': {fill: 'none'} }
					});
					if (!composite) {
						JJSdiagram.paper.model.addCell(link);
					}
					else {
						JJSdiagram.JJsParse.notYetAddedTransitionsStack.push(link);
					}
				}
			};

			var instantiateTransition = function(transition) {
				// Must check whether both source and target are in the graph already.
				var sourceCell = _.find(JJSdiagram.paper.model.getCells(), { "id": transition.source.id });
				var targetCell = _.find(JJSdiagram.paper.model.getCells(), { "id": transition.target.id });

				var link = new joint.shapes.uml_state_machine.Transition(transition);

				// Can get rid of this once the CSS bugs are fixed
				link.attr({ '.connection-wrap': {fill: 'none'}, '.connection': {fill: 'none'} });

				// Because the default font-size is 14
				var labels = link.get('labels');
				labels.forEach(function(label) {
					_.extend(label.attrs.text, {'font-size': 9 });
				});

				if (sourceCell && targetCell) {
					JJSdiagram.paper.model.addCell(link);
				}
				else {
					JJSdiagram.JJsParse.notYetAddedTransitionsStack.push(link);
				}

			};

			sm.states.forEach(instantiateState);

			sm.transitions.forEach(instantiateTransition);			
		}
	}
};
