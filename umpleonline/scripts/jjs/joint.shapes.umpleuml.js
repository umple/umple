joint.shapes.umpleuml = {};

//custom element
joint.shapes.umpleuml.Class = joint.shapes.basic.Rect.extend({
    defaults: joint.util.deepSupplement({
        type: 'umpleuml.Class',
        attrs: {
            rect: { stroke: 'none', 'fill-opacity': 0 }
        }
    }, joint.shapes.basic.Rect.prototype.defaults),

    getClassName: function () {
        return this.get('name');
    }
});

//a custom view
joint.shapes.umpleuml.ClassView = joint.dia.ElementView.extend({
    oldTimeout: null,

    targetInputSize: 9,

    template: [
        '<div class="html-element">',
        '<button class="delete">x</button>',
        '<img id="classIcon" style="position: absolute; top:.1em;left:.2em" src="scripts/class.png" alt="" width="13">',
        '<input size="9" type="text" class="className" readonly/>',
        '<div class="classAttributes">',
        '</div>',
        '<div class="classMethods">',
        '</div>',
        '</div>'
    ].join(''),

    initialize: function () {
        _.bindAll(this, 'updateBox');

        joint.dia.ElementView.prototype.initialize.apply(this, arguments);

        this.$box = jQuery(_.template(this.template)());

        //set setBackground color
        switch (this.model.get('backgroundColor')) {

            case "lightblue":
                this.$box.find('.html-element').prevObject[0].style.background = "#a1e9d9";
                break;

            case "lightgreen":
                this.$box.find('.html-element').prevObject[0].style.background = "#63f788";
                break;

            case "pink":
                this.$box.find('.html-element').prevObject[0].style.background = "#ffbac9";
                break;

            case "lightgrey":
                this.$box.find('.html-element').prevObject[0].style.background = "#eaeaea";
                break;

            case "":
                this.$box.find('.html-element').prevObject[0].style.background = "#ffffff";
                break;

            case "assigned":
                break;

            default:
                this.$box.find('.html-element').prevObject[0].style.background = this.model.get('backgroundColor');
        }

        //set state machien icon color
        if (this.model.get('hasStateMachine')) {
            this.$box.find('#classIcon')[0].style.background = "#ff0000";
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
            //save old name so that we can update code
            var oldName = this.model.get('name')[0];

            //for some reason(unknown), the class name is saved in an array.
            var className = this.model.get('name');
            className[0] = jQuery(e.target).val();
            this.model.set('name', className);

            //update box size
            this.updateBox();

            //update umple code
            JJSdiagram.makeUmpleCodeFromClass('editClassName', this.model.toJSON(), oldName);
        }, this));

        this.$box.find('.delete').on('click', _.bind(function () {
            JJSdiagram.makeUmpleCodeFromClass('removeClass', this.model.toJSON());
            this.model.remove();
        }, this));

        //update the box position whenever the underlying model chanegs.
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

    /**
     * only update the position when position changes
     */
    updatePosition: function () {
        if (this.oldTimeout) {
            clearTimeout(this.oldTimeout);
        }

        this.oldTimeout = setTimeout(_.bind(function () {
            JJSdiagram.makeUmpleCodeFromClass('moveClass', this.model.toJSON());
        }, this), 1000);
    },

    updateBox: function (donotupdate) {
        var bbox;

        //updating the HTML with a data stored in the cell model.

        //update view for class name section
        this.$box.find('.className').val(this.model.get('name')[0]);

        //update name input box size
        if (this.model.get('name')[0].length > this.targetInputSize) {
            this.targetInputSize = this.model.get('name')[0].length;
            this.$box.find('.className').prop('size', this.targetInputSize);
        }

        this.rerenderAttributes();
        this.rerenderMethods();

        this.addListeners();

        this.resetBoxsize();
    },

    removeBox: function (e) {
        this.$box.remove();
    },

    addListeners: function (e) {

        //enable input box when double click
        this.$box.find('input').off('dblclick').on('dblclick', _.bind(function (e) {
            e.target.readOnly = false;
        }, this));

        //disable input box when focusout
        this.$box.find('input').off('focusout').on('focusout', _.bind(function (e) {
            e.target.readOnly = true;
        }, this));

        //enter key pressed action
        this.$box.find('.classAttributes input').keypress(_.bind(function (e) {
            if (e.which === 13) {
                e.target.blur();
                setTimeout(_.bind(function () {
                    this.$box.find('.classAttributes input:last').prop('readonly', false);
                    this.$box.find('.classAttributes input:last').focus();
                }, this), 100);
            }
        }, this));

        //enter key pressted action
        this.$box.find('.classMethods input').keypress(_.bind(function (e) {
            if (e.which === 13) {
                e.target.blur();
                setTimeout(_.bind(function () {
                    this.$box.find('.classMethods input:last').prop('readonly', false);
                    this.$box.find('.classMethods input:last').focus();
                }, this), 100);
            }
        }, this));

        /**
         * when input focusout and last input box has value do the following
         *  - increase the index
         *  - add an extra empty input box
         *  - add the new data to model.
         *  - update code
         */
        this.$box.find('.classAttributes input').off('focusout').on('focusout', _.bind(function (e) {
            e.target.readOnly = true;
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


        /**
         * method works the same as attributes
         */
        this.$box.find('.classMethods input').off('focusout').on('focusout', _.bind(function (e) {
            e.target.readOnly = true;

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

        /**
         * delete attributes iron clicked
         */
        this.$box.find('.attributInput .deleteAttr').off('click').on('click', _.bind(function (e) {
            var attIndex = jQuery(e.target.parentNode.children[0]).data('attributeIndex');
            var attValue = jQuery(e.target.parentNode.children[0]).val();
            //value is empty, do nothing 
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

        //methods delete icon clicked
        this.$box.find('.methodInput .deleteMet').off('click').on('click', _.bind(function (e) {
            var metIndex = jQuery(e.target.parentNode.children[0]).data('methodIndex');
            var metValue = jQuery(e.target.parentNode.children[0]).val();
            //value is empty, do nothing 
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

        for (var j = 0; j < this.$box.find('.classAttributes input').size(); j++) {
            if (this.$box.find('.classAttributes input')[j].value.length > this.targetInputSize) {
                this.targetInputSize = this.$box.find('.classAttributes input')[j].value.length;
                updateFlag = true;
            }
        }

        this.resetBoxsize();

        setTimeout(_.bind(function () {
            if (updateFlag) {
                this.rerenderAttributes();

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

        for (var j = 0; j < this.$box.find('.classMethods input').size(); j++) {
            if (this.$box.find('.classMethods input')[j].value.length > this.targetInputSize) {
                this.targetInputSize = this.$box.find('.classMethods input')[j].value.length;
                updateFlag = true;
            }
        }

        this.resetBoxsize();

        setTimeout(_.bind(function () {
            if (updateFlag) {
                this.rerenderMethods();

                this.addListeners();
            }
        }, this), 200);
    },

    rerenderAttributes: function () {
        //clear attributes
        this.$box.find('.classAttributes').empty();

        //rerender attributes if showAttributes is checked
        if (this.model.get('attributes') && Page.showAttributes) {
            this.$box.find('.classAttributes').append('<hr>');

            var i = 0;

            for (i = 0; i < this.model.get('attributes').length; i++) {
                this.addAttributeBox(i, this.model.get('attributes')[i]);
            }

            //add an extra empty one
            this.addAttributeBox(i);
        }
    },

    rerenderMethods: function () {
        //clear methods
        this.$box.find('.classMethods').empty();

        //make sure show methods is checked
        if (this.model.get('methods') && Page.showMethods) {
            this.$box.find('.classMethods').append('<hr>');
            var i = 0;
            for (i = 0; i < this.model.get('methods').length; i++) {
                this.addMethodBox(i, this.model.get('methods')[i]);
            }
            this.addMethodBox(i);
        }
    },

    resetBoxsize: function () {
        //set box size
        var boxSize = this.model.get('size');
        boxSize['height'] = (this.$box.find('.classAttributes').children().size() + this.$box.find('.classMethods').children().size()) * 14 + 30;
        //boxSize['width'] = 50 + Math.floor(this.targetInputSize * 6.32);
        boxSize['width'] = 30 + Math.floor(this.targetInputSize * 6);
        this.model.set('size', boxSize);

        //set the position and dimension of the box so that it covers the JointJS element.
        var bbox = this.model.getBBox();

        this.$box.css({
            width: bbox.width,
            height: bbox.height,
            left: bbox.x+100,
            top: bbox.y+50,
            transform: 'rotate(' + (this.model.get('angle') || 0) + 'deg)'
        });
    }
});