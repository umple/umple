
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
        smooth: false
    }, joint.dia.Link.prototype.defaults)
});


//joint.shapes.uml_state_machine.StateNew = joint.shapes.
//joint.shapes.uml_state_machine.StateNew = joint.shapes.uml.State.extend({
joint.shapes.uml_state_machine.StateNew = joint.shapes.basic.Rect.extend({

    defaults: joint.util.deepSupplement({
        type: 'uml_state_machine.StateNew',
        attrs: {
            rect: { stroke: 'none', 'fill-opacity': 0 }
        }
    //}, joint.shapes.uml.State.prototype.defaults)
    }, joint.shapes.basic.Rect.prototype.defaults)
});

joint.shapes.uml_state_machine.StateNewView = joint.dia.ElementView.extend({
    oldTimeout: null,
    targetInputSize: 9,
    template: [
        '<div class="html-element html-state">',
        '<button class="delete">x</button>',
        '<input size="9" type="text" class="stateName" readonly/>',
        '<hr>',
        '<div class="stateActions">',
        '</div>',
        '<div class="stateActivities">',
        '</div>',
        '</div>'
    ].join(''),
    initialize: function () {
        _.bindAll(this, 'updateBox');
        joint.dia.ElementView.prototype.initialize.apply(this, arguments);

        this.$box = jQuery(_.template(this.template)());

        // Prevent paper from handling pointerdown.
        this.$box.find('input').on('mousedown click', function (evt) {
            evt.stopPropagation();
        });

        //bind enter key
        this.$box.find('.stateName').keypress(_.bind(function (e) {
            if (e.which === 13) {
                e.target.blur();
            }
        }, this));

        //this is reacting on the input change and storing the input data in the cell model
        this.$box.find('.stateName').on('change', _.bind(function (e) {
            //update name in model
            this.model.set('name', jQuery(e.target).val());
            //update box size/input size
            //always keep the largest one
            if (jQuery(e.target).val().length > this.targetInputSize) {
                this.targetInputSize = jQuery(e.target).val().length;
                this.$box.find('.stateName').prop('size', this.targetInputSize);
                this.updateBox();
            }

            //should update umple code here
        }, this));

        //remove object
        this.$box.find('.delete').on('click', _.bind(function () {
            //should update umple code here
            this.model.remove();
        }, this));

        // Update the box position whenever the underlying model changes.
        this.model.on('change', this.updateBox, this);

        // Remove the box when the model gets removed from the graph.
        this.model.on('remove', this.removeBox, this);

        this.updateBox();
    },

    render: function () {
        joint.dia.ElementView.prototype.render.apply(this, arguments);
        this.paper.$el.prepend(this.$box);
        this.updateBox();
        return this;
    },

    updateBox: function () {
        // Set the position and dimension of the box so that it covers the JointJS element.
        var bbox;

        //update name
        this.$box.find('.stateName').val(this.model.get('name'));

        //update box size
        if (this.model.get('name').length > this.targetInputSize) {
            this.targetInputSize = this.model.get('name').length;
            this.$box.find('.stateName').prop('size', this.targetInputSize);
        }

        //clear events
        this.$box.find('.stateActions').empty();

        //re-render events
        if (this.model.get('actions')) {
            var i = 0;

            for (i = 0; i < this.model.get('actions').length; i++) {
                this.addEventBox(i, this.model.get('actions')[i]);
            }
            //add empty one
            this.addEventBox(i);
        }

        //clear activities
        this.$box.find('.stateActivities').empty();
        //re-render events
        if(this.model.get('activities') && this.model.get('activities').length > 0) {
            this.$box.find('.stateActivities').append('Activities:');
            var stateActivities = this.model.get('activities')[0].trim().split(" +");
            var i = 0;
            for (; i < stateActivities.length; i++) {
                this.addActivityBox(i, stateActivities[i]);
            }
        }


        this.addListeners();
        //set box size
        var boxSize = this.model.get('size');
        boxSize['height'] = this.$box.find('.stateActions').children().size() * 16 + this.$box.find('.stateActivities').children().size() * 16+ 50;
        boxSize['width'] = 40 + 8 * this.targetInputSize;
        this.model.set('size', boxSize);

        bbox = this.model.getBBox();

        this.$box.css({
            width: bbox.width,
            height: bbox.height,
            left: bbox.x+100,
            top: bbox.y+50,
            transform: 'rotate(' + (this.model.get('angle') || 0) + 'deg)'
        });

    },

    removeBox: function (e) {
        this.$box.remove();
    },

    addListeners: function (e) {
        //enable input box when double click
        this.$box.find('input').off('dblclick').on('dblclick', _.bind(function (e) {
            e.target.readOnly = false;
        }, this));

        //disable when focusout
        this.$box.find('input').off('focusout').on('focusout', _.bind(function (e) {
            e.target.readOnly = true;
        }, this));

        //focusout input when 'Enter' key pressed
        this.$box.find('.stateActions input').keypress(_.bind(function (e) {
            if (e.which === 13) {
                e.target.blur();
                setTimeout(_.bind(function () {
                    this.$box.find('.stateActions input:last').prop('readonly', false);
                    this.$box.find('.stateActions input:last').focus();
                }, this), 100);
            }
        }, this));

        //focusout input when 'Enter' key pressed
        this.$box.find('.stateActivities input').keypress(_.bind(function (e) {
            if (e.which === 13) {
                e.target.blur();
                setTimeout(_.bind(function () {
                    this.$box.find('.stateActivities input:last').prop('readonly', false);
                    this.$box.find('.stateActivities input:last').focus();
                }, this), 100);
            }
        }, this));

        /**
         * focus out event of input box
         */
        this.$box.find('.eventInput input').off('focusout').on('focusout', _.bind(function (e) {
            e.target.readOnly = true;

            //if the last input has value
            //add an input box at the end.
            //***there is a bug here-->when last --> val()!=='',
            if (this.$box.find('.stateActions input:last').val()) {
                var tempIndex = this.$box.find('.stateActions input:last').data('eventIndex') + 1;
                this.addEventBox(tempIndex);
                this.addListeners();
                var temp = this.model.get('actions');
                temp[jQuery(e.target).data('eventIndex')] = jQuery(e.target).val();
                this.model.set('actions', temp);
                //should update umple code here
            }
        }, this));

        /**
         * focus out activities of input box
         */
        this.$box.find('.activityInput input').off('focusout').on('focusout', _.bind(function (e) {
            e.target.readOnly = true;

            //if the last input has value
            //add an input box at the end.
            //***there is a bug here-->when last --> val()!=='',
            if (this.$box.find('.stateActivities input:last').val()) {
                var tempIndex = this.$box.find('.stateActivities input:last').data('activityIndex') + 1;
                this.addActivityBox(tempIndex);
                this.addListeners();
                var temp = this.model.get('activities');
                temp+=" "+jQuery(e.target).val();
                this.model.set('activities', temp);
                //should update umple code here
            }
        }, this));


        this.$box.find('.stateActions .deleteEvent').off('click').on('click', _.bind(function (e) {
            var eventIndex = jQuery(e.target.parentNode.children[0]).data('eventIndex');
            var eventValue = jQuery(e.target.parentNode.children[0]).val();

            //value is empty, do nothing (might cause bug that needs to be fixed later)
            //value is not empty, delete the attribute from model and update box
            if (eventValue && eventIndex > -1) {

                var modelEvents = this.model.get('actions');
                modelEvents.splice(eventIndex, 1);
                this.model.set('actions', modelEvents);
                this.updateBox();

                //should update umple code here 
            }

        }, this));
    },

    addEventBox: function (tempIndex, inputValue) {
        var updateFlag = false;

        //add input
        if (inputValue) {
            this.$box.find('.stateActions').append('<div class="eventInput"><input size="' + this.targetInputSize + '" data-event-index="' + tempIndex + '" type="text" value="' + inputValue + '" placeholder="Add More" readonly/> <img class="deleteEvent" src="scripts/delete.png" alt="Del"></div>');
        }
        else {
            this.$box.find('.stateActions').append('<div class="eventInput"><input size="' + this.targetInputSize + '" data-event-index="' + tempIndex + '" type="text" value="" placeholder="Add More" readonly/> <img class="deleteEvent" src="scripts/delete.png" alt="Del"></div>');
        }

        //updated box height
        var boxSize = this.model.get('size');
        boxSize['height'] = this.$box.find('.stateActions').children().size() * 16 + this.$box.find('.stateActivities').children().size() * 16 + 35;


        //updated box width
        //the function below is the same as updateBox, need refactor.
        for (var j = 0; j < this.$box.find('.stateActions input').size(); j++) {
            if (this.$box.find('.stateActions input')[j].value.length > this.targetInputSize) {
                this.targetInputSize = this.$box.find('.stateActions input')[j].value.length;
                updateFlag = true;
            }
        }
        boxSize['width'] = 40 + 8 * this.targetInputSize;

        this.model.set('size', boxSize);
        var bbox = this.model.getBBox();
        this.$box.css({
            width: bbox.width,
            height: bbox.height,
            left: bbox.x+100,
            top: bbox.y+50,
            transform: 'rotate(' + (this.model.get('angle') || 0) + 'deg)'
        });

        setTimeout(_.bind(function () {
            if (updateFlag) {
                //clear events
                this.$box.find('.stateActions').empty();

                //rerender events
                var i = 0;

                for (i = 0; i < this.model.get('actions').length; i++) {
                    this.addEventBox(i, this.model.get('actions')[i]);
                }

                this.addEventBox(i);

                this.addListeners();

            }
        }, this), 200);
    },

    addActivityBox: function (tempIndex, inputValue) {
        var updateFlag = false;

        //add input
        if (inputValue) {
            this.$box.find('.stateActivities').append('<div class="activityInput"><input size="' + this.targetInputSize + '" data-activity-index="' + tempIndex + '" type="text" value="' + inputValue + '" placeholder="Add More" readonly/></div>');
        }
        else {
            this.$box.find('.stateActivities').append('<div class="activityInput"><input size="' + this.targetInputSize + '" data-activity-index="' + tempIndex + '" type="text" value="" placeholder="Add More" readonly/></div>');
        }

        //updated box height
        var boxSize = this.model.get('size');
        boxSize['height'] = this.$box.find('.stateActions').children().size() * 16 +this.$box.find('.stateActivities').children().size() * 16 + 35;


        //updated box width
        //the function below is the same as updateBox, need refactor.
        for (var j = 0; j < this.$box.find('.stateActivities input').size(); j++) {
            if (this.$box.find('.stateActivities input')[j].value.length > this.targetInputSize) {
                this.targetInputSize = this.$box.find('.stateActivities input')[j].value.length;
                updateFlag = true;
            }
        }
        boxSize['width'] = 40 + 8 * this.targetInputSize;

        this.model.set('size', boxSize);
        var bbox = this.model.getBBox();
        this.$box.css({
            width: bbox.width,
            height: bbox.height,
            left: bbox.x+100,
            top: bbox.y+50,
            transform: 'rotate(' + (this.model.get('angle') || 0) + 'deg)'
        });

        setTimeout(_.bind(function () {
            if (updateFlag) {
                //clear events
                this.$box.find('.stateActivities').empty();

                //rerender activities
                var i = 0;

                this.$box.find('.stateActivities').append('Activities:');
                var stateActivities = this.model.get('activities')[0].trim().split(" +");
                var i = 0;
                for (; i < stateActivities.length; i++) {
                    this.addActivityBox(i, stateActivities[i]);
                }

                this.addListeners();
            }
        }, this), 200);
    }
});