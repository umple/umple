joint.shapes.umpleuml = {};

//custom element
joint.shapes.umpleuml.Class = joint.shapes.basic.Rect.extend({
    defaults: joint.util.deepSupplement({
        type: 'umpleuml.Class',
        attrs: {
            rect: { stroke: 'none', 'fill-opacity': 0 }
        }
    }, joint.shapes.basic.Rect.prototype.defaults),

    getClassName: function() {
        return this.get('name');
    },
    getBackgroundColoe: function(){
        return this.get('getBackgroundColor')
    }
});

//a custom view
joint.shapes.umpleuml.ClassView = joint.dia.ElementView.extend({
    oldTimeout: null,
    targetInputSize: 9,
    template: [
        '<div class="html-element">',
        '<button class="delete">x</button>',
        '<img src="scripts/class.png" alt="">',
        '<input size="9" type="text" class="className" readonly/>',
        '<div class="classAttributes">',
        '<hr>',
        '</div>',
        '<div class="classMethods">',
        '<hr>',
        '</div>',
        '</div>'
    ].join(''),
    initialize: function () {
        _.bindAll(this, 'updateBox');
        joint.dia.ElementView.prototype.initialize.apply(this, arguments);

        this.$box = jQuery(_.template(this.template)());

        //set setBackground
        switch (this.model.get('backgroundColor')) {

            case "lightblue":
                this.$box.find('.html-element').prevObject[0].style.background="#a1e9d9";
                break;

            case "lightgreen":
                this.$box.find('.html-element').prevObject[0].style.background="#63f788";
                break;

            case "pink":
                this.$box.find('.html-element').prevObject[0].style.background="#ffbac9";
                break;

            case "lightgrey":
                this.$box.find('.html-element').prevObject[0].style.background="#eaeaea";
                break;

            case "":
                this.$box.find('.html-element').prevObject[0].style.background="#ffffff";
                break;

            case "assigned":
                break;

            default:
                this.$box.find('.html-element').prevObject[0].style.background=this.model.get('backgroundColor');
        }
        

        // Prevent paper from handling pointerdown.
        this.$box.find('input').on('mousedown click', function (e) {
            e.stopPropagation();
        });

        //bind enter key
        this.$box.find('.className').keypress(_.bind(function (e) {
            if (e.which === 13) {
                e.target.blur();
            }
        }, this));

        //this is reacting on the input change and storing the input data in the cell model
        this.$box.find('.className').on('change', _.bind(function (e) {
            var oldName = this.model.get('name')[0];

            var className = this.model.get('name');
            className[0] = jQuery(e.target).val();
            this.model.set('name', className);
            if (jQuery(e.target).val().length > this.targetInputSize) {
                this.targetInputSize = jQuery(e.target).val().length;
                this.$box.find('.className').prop('size', this.targetInputSize);
                this.updateBox();
            }

            //update umple code
            JJSdiagram.makeUmpleCodeFromClass('editClassName', this.model.toJSON(), oldName);
        }, this));

        //this.$box.find('.delete').on('click', _.bind(this.model.remove, this.model));
        this.$box.find('.delete').on('click', _.bind(function(){
            JJSdiagram.makeUmpleCodeFromClass('removeClass', this.model.toJSON());
            this.model.remove();
        },this));

        //update the box position whenever the underlying model chanegs.
        //this.model.on('change:position', this.updateBox, this);
        this.model.on('change', this.updateBox, this);
        this.model.on('change:position', this.updatePosition, this);
        this.model.on('remove', this.removeBox, this);

        this.updateBox();

    },
    
    render: function () {
        joint.dia.ElementView.prototype.render.apply(this, arguments);
        this.paper.$el.prepend(this.$box);
        this.updateBox();
        return this;
    },

    updatePosition: function(){
        if (this.oldTimeout) {
            clearTimeout(this.oldTimeout);
        }
        this.oldTimeout = setTimeout(_.bind(function () {
            JJSdiagram.makeUmpleCodeFromClass('moveClass', this.model.toJSON());
        },this), 1000);
    },

    updateBox: function () {
        //set the position and dimension of the box so that it covers the JointJS element.
        var bbox;

        //updating the HTML with a data stored in the cell model.
        this.$box.find('.className').val(this.model.get('name')[0]);

        //update box size
        if (this.model.get('name')[0].length > this.targetInputSize) {
            this.targetInputSize = this.model.get('name')[0].length;
            this.$box.find('.className').prop('size', this.targetInputSize);
        }

        //clear attributes
        this.$box.find('.classAttributes').empty();
        this.$box.find('.classMethods').empty();

        //rerender attributes if checked
        if( this.model.get('attributes') && Page.showAttributes ){
            this.$box.find('.classAttributes').append('<hr>');
            var i = 0;

            for (i = 0; i < this.model.get('attributes').length; i++) {
                this.addAttributeBox(i, this.model.get('attributes')[i]);
            }

            this.addAttributeBox(i);
        }

        if (this.model.get('methods') && Page.showMethods) {
            this.$box.find('.classMethods').append('<hr>');
            var i = 0;
            for (i = 0; i < this.model.get('methods').length; i++) {
                this.addMethodBox(i, this.model.get('methods')[i]);
            }
            this.addMethodBox(i);
        }

        this.addListeners();

        //set box size
        var boxSize = this.model.get('size');
        boxSize['height'] = this.$box.find('.classAttributes').children().size() * 16 + this.$box.find('.classMethods').children().size() * 16 + 35;
        boxSize['width'] = 40 + 8 * this.targetInputSize;
        this.model.set('size', boxSize);

        bbox = this.model.getBBox();

        this.$box.css({
            width: bbox.width,
            height: bbox.height,
            left: bbox.x,
            top: bbox.y,
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

        this.$box.find('input').off('focusout').on('focusout', _.bind(function (e) {
            e.target.readOnly = true;
        }, this));

        this.$box.find('.classAttributes input').keypress(_.bind(function (e) {
            if (e.which === 13) {
                e.target.blur();
                setTimeout(_.bind(function () {
                    this.$box.find('.classAttributes input:last').prop('readonly', false);
                    this.$box.find('.classAttributes input:last').focus();
                }, this), 100);
            }
        }, this));

        this.$box.find('.classMethods input').keypress(_.bind(function (e) {
            if (e.which === 13) {
                e.target.blur();
                setTimeout(_.bind(function () {
                    this.$box.find('.classMethods input:last').prop('readonly', false);
                    this.$box.find('.classMethods input:last').focus();
                }, this), 100);
            }
        }, this));

        this.$box.find('.classAttributes input').off('focusout').on('focusout', _.bind(function (e) {
            e.target.readOnly = true;

            //if the last input has value
            //add an input box at the end.
            //***there is a bug here-->when last --> val()!=='',
            if (this.$box.find('.classAttributes input:last').val()) {
                var tempIndex = this.$box.find('.classAttributes input:last').data('attributeIndex') + 1;
                this.addAttributeBox(tempIndex);
                this.addListeners();
                var temp = this.model.get('attributes');
                temp[jQuery(e.target).data('attributeIndex')] = jQuery(e.target).val();
                this.model.set('attributes', temp);

                JJSdiagram.makeUmpleCodeFromClass('addAttribute', this.model.toJSON(), jQuery(e.target).data('attributeIndex'));
            }

        }, this));

        this.$box.find('.classMethods input').off('focusout').on('focusout', _.bind(function (e) {
            e.target.readOnly = true;

            //if the last input has value
            //add an input box at the end.
            //***there is a bug here-->when last --> val()!=='',
            if (this.$box.find('.classMethods input:last').val()) {
                var tempIndex = this.$box.find('.classMethods input:last').data('methodIndex') + 1;
                this.addMethodBox(tempIndex);
                this.addListeners();
                var temp = this.model.get('methods');
                temp[jQuery(e.target).data('methodIndex')] = jQuery(e.target).val();
                this.model.set('methods', temp);

                JJSdiagram.makeUmpleCodeFromClass('addMethod', this.model.toJSON(), jQuery(e.target).data('methodIndex'));
            }

        }, this));

        this.$box.find('.attributInput .deleteAttr').off('click').on('click', _.bind(function (e) {
            var attIndex = jQuery(e.target.parentNode.children[0]).data('attributeIndex');
            var attValue = jQuery(e.target.parentNode.children[0]).val();
            //value is empty, do nothing (might cause bug that needs to be fixed later)
            //value is not empty, delete the attribute from model and update box
            if (attValue && attIndex > -1) {
                var oldAttribute = this.model.get('attributes')[attIndex];

                var modelAttributes = this.model.get('attributes');
                modelAttributes.splice(attIndex, 1);
                this.model.set('attributes', modelAttributes);
                this.updateBox();

                JJSdiagram.makeUmpleCodeFromClass('removeAttribute', this.model.toJSON(), oldAttribute);
            }

        }, this));

        this.$box.find('.methodInput .deleteMet').off('click').on('click', _.bind(function (e) {
            var metIndex = jQuery(e.target.parentNode.children[0]).data('methodIndex');
            var metValue = jQuery(e.target.parentNode.children[0]).val();
            //value is empty, do nothing (might cause bug that needs to be fixed later)
            //value is not empty, delete the attribute from model and update box
            if (metValue && metIndex > -1) {
                var oldMethod = this.model.get('methods')[metIndex];

                var modelMethods = this.model.get('methods');
                modelMethods.splice(metIndex, 1);
                this.model.set('methods', modelMethods);
                this.updateBox();

                JJSdiagram.makeUmpleCodeFromClass('removeMethod', this.model.toJSON(), oldMethod);
            }

        }, this));
    },

    addAttributeBox: function (tempIndex, inputValue) {
        var updateFlag = false;
        if (inputValue) {
            this.$box.find('.classAttributes').append('<div class="attributInput"><input size="' + this.targetInputSize + '" data-attribute-index="' + tempIndex + '" type="text" value="' + inputValue + '" placeholder="Add More" readonly/> <img class="deleteAttr" src="scripts/delete.png" alt="Del"></div>');
        }
        else {
            this.$box.find('.classAttributes').append('<div class="attributInput"><input size="' + this.targetInputSize + '" data-attribute-index="' + tempIndex + '" type="text" value="" placeholder="Add More" readonly/> <img class="deleteAttr" src="scripts/delete.png" alt="Del"></div>');
        }

        //updated box height
        var boxSize = this.model.get('size');
        boxSize['height'] = this.$box.find('.classAttributes').children().size() * 16 + this.$box.find('.classMethods').children().size() * 16+ 35;


        //updated box width
        //the function below is the same as updateBox, need refactor.
        for (var j = 0; j < this.$box.find('.classAttributes input').size(); j++) {
            if (this.$box.find('.classAttributes input')[j].value.length > this.targetInputSize) {
                this.targetInputSize = this.$box.find('.classAttributes input')[j].value.length;
                updateFlag = true;
            }
        }
        boxSize['width'] = 40 + 8 * this.targetInputSize;

        this.model.set('size', boxSize);
        var bbox = this.model.getBBox();
        this.$box.css({
            width: bbox.width,
            height: bbox.height,
            left: bbox.x,
            top: bbox.y,
            transform: 'rotate(' + (this.model.get('angle') || 0) + 'deg)'
        });

        setTimeout(_.bind(function () {
            if (updateFlag) {
                //clear attributes
                this.$box.find('.classAttributes').empty();

                this.$box.find('.classAttributes').append('<hr>');
                //rerender attributes
                var i = 0;

                for (i = 0; i < this.model.get('attributes').length; i++) {
                    this.addAttributeBox(i, this.model.get('attributes')[i]);
                }

                this.addAttributeBox(i);

                this.addListeners();

            }
        }, this), 200);
    },

    addMethodBox: function (tempIndex, inputValue) {
        var updateFlag = false;
        if (inputValue) {
            this.$box.find('.classMethods').append('<div class="methodInput"><input size="' + this.targetInputSize + '" data-method-index="' + tempIndex + '" type="text" value="' + inputValue + '" placeholder="Add More" readonly/> <img class="deleteMet" src="scripts/delete.png" alt="Del"></div>');
        }
        else {
            this.$box.find('.classMethods').append('<div class="methodInput"><input size="' + this.targetInputSize + '" data-method-index="' + tempIndex + '" type="text" value="" placeholder="Add More" readonly/> <img class="deleteMet" src="scripts/delete.png" alt="Del"></div>');
        }

        //updated box height
        var boxSize = this.model.get('size');
        boxSize['height'] = this.$box.find('.classAttributes').children().size() * 16 + this.$box.find('.classMethods').children().size() * 16 + 35;


        //updated box width
        //the function below is the same as updateBox, need refactor.
        for (var j = 0; j < this.$box.find('.classMethods input').size(); j++) {
            if (this.$box.find('.classMethods input')[j].value.length > this.targetInputSize) {
                this.targetInputSize = this.$box.find('.classMethods input')[j].value.length;
                updateFlag = true;
            }
        }
        boxSize['width'] = 40 + 8 * this.targetInputSize;

        this.model.set('size', boxSize);
        var bbox = this.model.getBBox();
        this.$box.css({
            width: bbox.width,
            height: bbox.height,
            left: bbox.x,
            top: bbox.y,
            transform: 'rotate(' + (this.model.get('angle') || 0) + 'deg)'
        });

        setTimeout(_.bind(function () {
            if (updateFlag) {
                //clear attributes
                this.$box.find('.classMethods').empty();
                this.$box.find('.classMethods').append('<hr>');
                //rerender attributes
                var i = 0;

                for (i = 0; i < this.model.get('methods').length; i++) {
                    this.addMethodBox(i, this.model.get('methods')[i]);
                }

                this.addMethodBox(i);

                this.addListeners();

            }
        }, this), 200);
    }
});