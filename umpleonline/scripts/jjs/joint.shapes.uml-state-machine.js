
joint.shapes.uml_state_machine = {};

joint.shapes.uml_state_machine.StateMachine = {};

joint.shapes.uml_state_machine.CompositeState = joint.shapes.basic.Generic.extend({

    markup: [
        '<g class="rotatable">',
        '<rect class="composite-state-rect"/>',
        '<g class="scalable">',
        '<line class="composite-state-separator"/>',
        '</g>',
        '<text class="composite-state-text"/>',
        '</g>'
        ].join(''),

    defaults: _.defaultsDeep({

        type: 'uml_state_machine.CompositeState',

        attrs: {

            // We want the state to take as little space as possible during auto-layout.
            rect: { 'width': 1 },

            '.composite-state-rect': { 'stroke': '#000000', 'stroke-width': 2, 'fill': '#ffffff', 'fill-opacity': '0.0', 'rx': 25, 'ry': 25},

            '.composite-state-text': {
                'ref': '.composite-state-rect', 'ref-y': 2, 'ref-x': .5, 'text-anchor': 'middle', 'y-alignment': 'top', 'font-weight': 'bold',
                'fill': 'black', 'font-size': 14, 'font-family': 'Times New Roman'
            }
        },

        name: [],
        nestedStates: []

    }, joint.shapes.basic.Generic.prototype.defaults),


    updateRectangles: function(paper) {

        var attrs = this.get('attrs');

        attrs['.composite-state-text'].text = this.getCompStateName();

        // Noting that this part of the update procedure should take place after the graph
        // has auto-layout applied, and before this cell has been added to the graph.
        if (paper !== undefined) {
            var bbox = paper.model.getBBox(this.get('nestedStates'));

            attrs['.composite-state-rect'].width = bbox.width + 20;
            attrs['.composite-state-rect'].height = bbox.height + 40;
            attrs['.composite-state-rect'].x = bbox.x - 10;
            attrs['.composite-state-rect'].y = bbox.y - 30;
        }
    },

    /*
     * doEmbed performs the task of converting the names of cells into cell references,
     * then performs the embed() function with them.
     * Note that this must be called before updateRectangles() in order to get correct resizing.
     */
    doEmbed: function(paper) {
        var nestedCells = [];
        this.get('nestedStates').forEach(function(name) {
            nestedCells.push(paper.model.getCell(name));
        });
        this.set({'nestedStates': nestedCells });

        var nestedCells = this.get('nestedStates');
        for (var i = 0; i < nestedCells.length; i++) {
            this.embed(nestedCells[i]);            
        }
    },

    initialize: function() {

        this.on('change:name', function() {
            this.updateRectangles();
            this.trigger('uml-update');
        }, this);

        joint.shapes.basic.Generic.prototype.initialize.apply(this, arguments);
    },

    getCompStateName: function() {
        return this.get('name');
    }

});
joint.shapes.uml_state_machine.BackButton = joint.shapes.basic.Generic.extend({

    markup: [
        '<g class="rotatable">',
        '<g class="scalable">',
        '<rect class="button-rect"/>',
        '</g>',
        '<text class="button-text"/>',
        '</g>'
        ].join(''),

    defaults: _.defaultsDeep({

        type: 'uml_state_machine.BackButton',

        attrs: {
            rect: { 'width': 100 },

            '.button-rect': { 'stroke': '#318c00', 'stroke-width': 2, 'fill': '#64e220', 'rx': 8, 'ry': 8, 'width': 110, 'height': 35 },

            '.button-text': {
                'ref': '.button-rect', 'ref-y': .5, 'ref-x': .5, 'text-anchor': 'middle', 'y-alignment': 'middle', 'font-weight': 'bold',
                'fill': 'black', 'font-size': 14, 'font-family': 'Times New Roman'
            }
        }
    }),

    initialize: function() {

        this.on('change:name change:actions change:internals', function() {
            this.updateRectangles();
            this.trigger('uml-update');
        }, this);

        this.updateRectangles();

        joint.shapes.basic.Generic.prototype.initialize.apply(this, arguments);
    },

    updateRectangles: function() {

        var attrs = this.get('attrs');

        attrs['.button-text'].text = '< UML class';
    }

});

joint.shapes.uml_state_machine.State = joint.shapes.basic.Generic.extend({

    markup: [
        '<g class="rotatable">',
        '<g class="scalable">',
        '<rect class="state-name-rect"/>',
        '</g>',
        '<line class="state-actions-separator"/>',
        '<line class="state-internals-separator"/>',
        '<text class="state-name-text"/>',
        '<text class="state-actions-text"/><text class="state-internals-text"/>',
        '</g>'
    ].join(''),

    defaults: _.defaultsDeep({

        type: 'uml_state_machine.State',

        attrs: {
            rect: { 'width': 150 },

            '.state-name-rect': { 'stroke': 'black', 'stroke-width': 2, 'fill': '#f9f9f9', 'rx': 15, 'ry': 15 },

            '.state-name-text': {
                'ref': '.state-name-rect', 'ref-y': 12, 'ref-x': .5, 'text-anchor': 'middle', 'y-alignment': 'middle', 'font-weight': 'bold',
                'fill': 'black', 'font-size': 12, 'font-family': 'Times New Roman'
            },
            '.state-actions-text': {
                'ref': '.state-name-rect', 'ref-y': 25, 'ref-x': 10,
                'fill': 'black', 'font-size': 12, 'font-family': 'Times New Roman'
            },
            '.state-internals-text': {
                'ref': '.state-name-rect', 'ref-y': 60, 'ref-x': 10,
                'fill': 'black', 'font-size': 12, 'font-family': 'Times New Roman'
            },
            '.state-actions-separator': {
                'stroke': 'black', 'stroke-width': 2, 'fill': '#fff', 'x1': 0, 'y1': 20, 'x2': 150, 'y2': 20 
            },
            '.state-internals-separator': {
                'stroke': 'black', 'stroke-width': 2, 'fill': '#fff', 'x1': 0, 'y1': 0, 'x2': 150, 'y2': 0 
            }
        },

        name: [],
        actions: [],
        internals: []

    }, joint.shapes.basic.Generic.prototype.defaults),

    initialize: function() {

        this.on('change:name change:actions change:internals', function() {
            this.updateRectangles();
            this.trigger('uml-update');
        }, this);

        this.updateRectangles();

        joint.shapes.basic.Generic.prototype.initialize.apply(this, arguments);
    },

    getStateName: function() {
        return this.get('name');
    },

    updateRectangles: function() {

        var attrs = this.get('attrs');

        var fields = [
            { type: 'name', text: this.getStateName() },
            { type: 'actions', text: this.get('actions') },
            { type: 'internals', text: this.get('internals') }
        ];

        var offsetY = 0, maxWidth = this.attributes.size.width, offsetInternals, lengthInternals;

        _.each(fields, function(field) {

            var lines = _.isArray(field.text) ? field.text : [field.text];
            lines.forEach(function(line) {
                if (line !== null) {
                    if ( 20 + line.length * 6 > maxWidth) {
                        maxWidth = 20 + line.length * 6;
                    }                       
                }
            });

            var fieldHeight = lines[0] != null ? lines.length * 15 + 5 : 20;

            attrs['.state-' + field.type + '-text'].text = lines.join('\n');

            if (field.type === 'internals') {
            	offsetInternals = offsetY;
            	lengthInternals = lines.length > 0 ? maxWidth : 0;
            }

            offsetY += fieldHeight;
        });

        attrs['.state-name-rect'].height = offsetY;
        attrs['.state-name-rect'].width = maxWidth;
        attrs['.state-actions-separator'].x2 = maxWidth;

        this.attr( {'.state-internals-text': {'ref-y': offsetInternals + 3},
                    '.state-internals-separator': {'y1': offsetInternals, 'y2': offsetInternals, 'x2': lengthInternals} });
        
        this.resize(maxWidth, offsetY);

    }

});

joint.shapes.uml_state_machine.PseudoStart = joint.dia.Element.extend({

    markup: '<g class="rotatable"><g class="scalable"><circle/></g></g>',

    defaults: _.defaultsDeep({

        type: 'uml_state_machine.PseudoStart',
        size: { width: 20, height: 20 },
        attrs: {
            circle: {
                transform: 'translate(10, 10)',
                r: 10,
                fill: '#000000'
            }
        }
    }, joint.dia.Element.prototype.defaults)
});

/*
 * Note the arrow scoots around the text. Actually, there is a bounding box around
 * the composite element that defines how it connects.
 * Also, the addition of the text makes the arrow point to the middle of the larger
 * bounding rectangle, upsetting the focus on the center of the circle.
 */
joint.shapes.uml_state_machine.FinalState = joint.dia.Element.extend({

    markup: ['<g class="rotatable">',
            '<g class="scalable">',
            '<circle class="outer"/>',
            '<circle class="inner"/>',
            '</g>',
            '<text class="final-state-name"/>',
            '</g>'].join(''),

    defaults: _.defaultsDeep({

        type: 'fsa.EndState',
        size: { width: 30, height: 30 },
        attrs: {
            '.outer': {
                transform: 'translate(10, 10)',
                r: 8,
                fill: '#ffffff',
                stroke: '#000000'
            },

            '.inner': {
                transform: 'translate(10, 10)',
                r: 6,
                fill: '#000000'
            }

            ,'.final-state-name': {
                'ref': '.outer', 'ref-y': 45, 'ref-x': .5, 'text-anchor': 'middle', 'y-alignment': 'middle', 'font-weight': 'bold',
                'fill': 'black', 'font-size': 12, 'font-family': 'Times New Roman'
            }

        }

    }, joint.dia.Element.prototype.defaults)
});

joint.shapes.uml_state_machine.Transition = joint.dia.Link.extend({

    defaults: _.defaultsDeep({
        type: 'uml_state_machine.Transition',
        attrs: { '.marker-target': { d: 'M 10 0 L 0 5 L 10 10 z' }},
        smooth: true
    }, joint.dia.Link.prototype.defaults)
});
