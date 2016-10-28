var JJsParse = {

	addAttributes: function (attrs) {
		// { "type" : "String", "name" : "startTime", "modifier" : "", "traceColor" : "black" }
		var attributes = new Array();

		var parseAttributes = function (attribute) {
			var text = JJsParse.makeModifier(attribute.modifier) + " " + attribute.name + ": " + attribute.type;
			attributes.push(text);
		};

		attrs.forEach(parseAttributes);
		return attributes;
	},

	addMethods: function(meths) {
		// {type: "void", name: "setDoorTimer", parameters: "Integer", visibility: "public", isAbstract: "false"}
		// console.log(meths);
		var methods = new Array();

		var parseMethods = function (method) {
			var text =  JJsParse.makeModifier(method.visibility) + " " + method.name + "(" + method.parameters + ") : " + method.type;
			methods.push(text);  
		};

		meths.forEach(parseMethods);

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

	makeClasses: function (model) {
		var classes = new Array();

		var instantiate = function(UMLclass) {
			var new_class;

			if (UMLclass.isAbstract === "true") {
				// console.log("made ABSTRACT class");
				new_class = new joint.shapes.uml.Abstract({
					position: UMLclass.position,
					size: UMLclass.position,
					name: [UMLclass.name],
					attributes: JJsParse.addAttributes(UMLclass.attributes),
					methods: JJsParse.addMethods(UMLclass.methods),
					id: UMLclass.id
				});
			}
			else if (UMLclass.isInterface === "true") {
				// console.log("made INTERFACE class");
				new_class = new joint.shapes.uml.Interface({
					position: UMLclass.position,
					size: UMLclass.position,
					name: [UMLclass.name],
					attributes: JJsParse.addAttributes(UMLclass.attributes),
					methods: JJsParse.addMethods(UMLclass.methods),
					id: UMLclass.id
				});
			}
			else {
				// console.log("made reg class");
				new_class = new joint.shapes.uml.Class({
					position: UMLclass.position,
					size: UMLclass.position,
					name: [UMLclass.name],
					attributes: JJsParse.addAttributes(UMLclass.attributes),
					methods: JJsParse.addMethods(UMLclass.methods),
					id: UMLclass.id
				});
			}

			classes.push(new_class);
			// console.log(new_class);
		};

		model.umpleClasses.forEach(instantiate);

		return classes;
	},

	makeAssociations: function(model) {
		var associations = new Array();

		var instantiate = function (UMLassoc) {
			var new_assoc;
			new_assoc = new joint.shapes.uml.Association({
		        source: { id: UMLassoc.classOneId },
		        target: { id: UMLassoc.classTwoId }
			});

			associations.push(new_assoc);
		};

		model.umpleAssociations.forEach(instantiate);

		return associations;
	}
};
