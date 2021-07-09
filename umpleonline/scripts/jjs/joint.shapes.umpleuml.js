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
        '<div class="html-element" style="text-align: center">',
        '<button class="delete">x</button>',
        '<img id="classIcon" style="position: absolute; top:.1em;left:.2em" src="scripts/class.png" alt="" width="13">',
        '<div class="className"><input size="9" type="text" class="className" placeholder="className" style="text-align: center" readonly/><img class="edit" src="scripts/pencil.png" alt="Edt"></div>',
        '<div class="classAttributes" style="text-align: left">',
        '</div>',
        '<div class="classMethods" style="text-align: left">',
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

        //set state machine icon color
        if (this.model.get('hasStateMachine')) {
            this.$box.find('#classIcon')[0].style.background = "#ff0000";
        }

        //hidden class Icon when photo ready checked
        if (jQuery('#buttonPhotoReady').prop('checked')){
			jQuery('img#classIcon').css('visibility', 'hidden');
		}

        //Prevent paper from handling pointerdown.
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

        //disable input box when focusout
        this.$box.find('input').off('focusout').on('focusout', _.bind(function (e) {
            e.target.readOnly = true;

			setTimeout(_.bind(function () {
				var editButton = jQuery(e.target.parentNode.children[1]);
				var inputField = jQuery(e.target.parentNode.children[0]);
				$(editButton).removeClass('iconSelected');
				$(inputField).css("pointer-events", "none");
			}, this), 100);
        }, this));

        //enter key pressed action
        this.$box.find('.classAttributes input').keypress(_.bind(function (e) {
            if (e.which === 13) {
                e.target.blur();
                setTimeout(_.bind(function () {
					if (e.target.value) {
						this.$box.find('.classAttributes input:last').prop('readonly', false);
						this.$box.find('.classAttributes input:last').focus();
						var editButton = jQuery(this.$box.find('.classAttributes input:last').parent().children()[2]);
						var inputField = jQuery(this.$box.find('.classAttributes input:last').parent().children()[0]);
						$(editButton).addClass('iconSelected');
						$(inputField).css("pointer-events", "auto");
					}
                }, this), 100);
            }
        }, this));

        //enter key pressed action
        this.$box.find('.classMethods input').keypress(_.bind(function (e) {
            if (e.which === 13) {
                e.target.blur();
                setTimeout(_.bind(function () {
					if (e.target.value) {
						this.$box.find('.classMethods input:last').prop('readonly', false);
						this.$box.find('.classMethods input:last').focus();
						var editButton = jQuery(this.$box.find('.classMethods input:last').parent().children()[2]);
						var inputField = jQuery(this.$box.find('.classMethods input:last').parent().children()[0]);
						$(editButton).addClass('iconSelected');
						$(inputField).css("pointer-events", "auto");
					}
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
                var attrName = e.target.value.trim();
                var newAttrName = "";

                if (attrName.split(":").length >= 2){
                	e.target.value = attrName.split(":")[0].trim() + ": " + attrName.split(":")[1].trim();
                	newAttrName = "- "+attrName.split(":")[0].trim() + ": " + attrName.split(":")[1].trim();
				}else {
					newAttrName = "- "+attrName.split(":")[0].trim() + ": " + "String";
				}

                var temp = this.model.get('attributes');
                temp[jQuery(e.target).data('attributeIndex')] = newAttrName;
                this.model.set('attributes', temp);

                JJSdiagram.makeUmpleCodeFromClass('addAttribute', this.model.toJSON(), jQuery(e.target).data('attributeIndex'));
            }else if (e.target.value !== ""){
            	var attributeIndex = this.$box.find('div.attributInput').index(jQuery(e.target).parent());
            	var oldName = this.model.get('attributes')[attributeIndex];
            	oldName = oldName.split(":")[0].substr(2);
				var attrs = this.model.get('attributes');

				if (e.target.value.split(":").length >= 2){
					e.target.value = e.target.value.split(":")[0].trim() + ": " + e.target.value.split(":")[1].trim();
					attrs[attributeIndex] = "- " +  e.target.value;
				}else{
					attrs[attributeIndex] = "- " +  e.target.value + ": String";
				}

				JJSdiagram.makeUmpleCodeFromClass('editAttribute', this.model.toJSON(), attributeIndex, oldName);
			}

			setTimeout(_.bind(function () {
				var editButton = jQuery(e.target.parentNode.children[2]);
				var inputField = jQuery(e.target.parentNode.children[0]);
				$(editButton).removeClass('iconSelected');
				$(inputField).css("pointer-events", "none");
			}, this), 100);

        }, this));


        /**
         * method works the same as attributes
         */
        this.$box.find('.classMethods input').off('focusout').on('focusout', _.bind(function (e) {
            e.target.readOnly = true;

            if (this.$box.find('.classMethods input:last').val()) {
                var tempIndex = this.$box.find('div.methodInput').index(jQuery(e.target).parent());
                this.addMethodBox(tempIndex);
                this.addListeners();

				var temp = this.model.get('methods');
                temp[jQuery(e.target).data('methodIndex')] = jQuery(e.target).val();
                this.model.set('methods', temp);

                JJSdiagram.makeUmpleCodeFromClass('addMethod', this.model.toJSON(), jQuery(e.target).data('methodIndex'));
            }

			setTimeout(_.bind(function () {
				var editButton = jQuery(e.target.parentNode.children[2]);
				var inputField = jQuery(e.target.parentNode.children[0]);
				$(editButton).removeClass('iconSelected');
				$(inputField).css("pointer-events", "none");
			}, this), 100);
        }, this));

        /**
         * delete attributes icon clicked
         */
        this.$box.find('.attributInput .deleteAttr').off('click').on('click', _.bind(function (e) {
            var attIndex = this.$box.find('div.attributInput').index(jQuery(e.target).parent());
            var attValue = jQuery(e.target.parentNode.children[0]).val();
            //value is empty, do nothing 
            //value is not empty, delete the attribute from model and update box
            if (attValue && attIndex > -1) {
                var oldAttribute = this.model.get('attributes')[attIndex].substr(2);
				//oldAttribute = oldAttribute.split(":");
                var modelAttributes = this.model.get('attributes');
                modelAttributes.splice(attIndex, 1);
                this.model.set('attributes', modelAttributes);
                this.updateBox();

                JJSdiagram.makeUmpleCodeFromClass('removeAttribute', this.model.toJSON(), oldAttribute);
            }

        }, this));

		this.$box.find('.attributInput .edit').off('click').on('click', _.bind(function (e) {
			var editButton = jQuery(e.target.parentNode.children[2]);
			var inputField = jQuery(e.target.parentNode.children[0]);

			if ($(editButton).hasClass('iconSelected')){
				$(inputField).blur();
				}
			else {
				var selectedItem = format("div.html-element img.edit.iconSelected");
				var enabledInput = format("div.html-element input")
				jQuery(selectedItem).removeClass("iconSelected");
				jQuery(enabledInput).css({"pointer-events": "none"});

				$(editButton).addClass('iconSelected');
				$(inputField).css("pointer-events", "auto");
				$(inputField).prop('readOnly', false);
				$(inputField).focus();
            }
		}, this));

		this.$box.find('.methodInput .edit').off('click').on('click', _.bind(function (e) {
			var editButton = jQuery(e.target.parentNode.children[2]);
			var inputField = jQuery(e.target.parentNode.children[0]);

			if ($(editButton).hasClass('iconSelected')){
				$(inputField).blur();
			}
			else {
				var selectedItem = format("div.html-element img.edit.iconSelected");
				var enabledInput = format("div.html-element input")
				jQuery(selectedItem).removeClass("iconSelected");
				jQuery(enabledInput).css({"pointer-events": "none"});

				$(editButton).addClass('iconSelected');
				$(inputField).css("pointer-events", "auto");
				$(inputField).prop('readOnly', false);
				$(inputField).focus();
			}
		}, this));

		this.$box.find('.className .edit').off('click').on('click', _.bind(function (e) {
			var editButton = jQuery(e.target.parentNode.children[1]);
			var inputField = jQuery(e.target.parentNode.children[0]);

			var selectedItem = format("div.html-element img.edit.iconSelected");
			var enabledInput = format("div.html-element input");

			if ($(editButton).hasClass('iconSelected'))
			{
				$(inputField).blur();
			}else {
				jQuery(selectedItem).removeClass("iconSelected");
				jQuery(enabledInput).css({"pointer-events": "none"});
				$(editButton).addClass('iconSelected');
				$(inputField).css("pointer-events", "auto");
				$(inputField).prop('readOnly', false);
				$(inputField).focus();
			}

		}, this));



		//methods delete icon clicked
        this.$box.find('.methodInput .deleteMet').off('click').on('click', _.bind(function (e) {
            var metIndex = this.$box.find('div.methodInput').index(jQuery(e.target).parent());
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
            this.$box.find('.classAttributes').append('<div class="attributInput"><input size="' + this.targetInputSize + '" data-attribute-index="' + tempIndex + '" type="text" value="' + inputValue + '" placeholder="Add More" readonly/> <img class="deleteAttr" src="scripts/delete.png" alt="Del"><img class="edit" src="scripts/pencil.png" alt="Edt"></div>');
        }
        else {
            this.$box.find('.classAttributes').append('<div class="attributInput"><input size="' + this.targetInputSize + '" data-attribute-index="' + tempIndex + '" type="text" value="" placeholder="Add More" readonly/> <img class="deleteAttr" src="scripts/delete.png" alt="Del"><img class="edit" src="scripts/pencil.png" alt="Edt"></div>');
        }

        for (var j = 0; j < this.$box.find('.classAttributes input').length; j++) {
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
        }, this), 100);
    },

    addMethodBox: function (tempIndex, inputValue) {
        var updateFlag = false;
        if (inputValue) {
            this.$box.find('.classMethods').append('<div class="methodInput"><input size="' + this.targetInputSize + '" data-method-index="' + tempIndex + '" type="text" value="' + inputValue + '" placeholder="Add More" readonly/> <img class="deleteMet" src="scripts/delete.png" alt="Del"><img class="edit" src="scripts/pencil.png" alt="Edt"></div>');
        }
        else {
            this.$box.find('.classMethods').append('<div class="methodInput"><input size="' + this.targetInputSize + '" data-method-index="' + tempIndex + '" type="text" value="" placeholder="Add More" readonly/> <img class="deleteMet" src="scripts/delete.png" alt="Del"><img class="edit" src="scripts/pencil.png" alt="Edt"></div>');
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
                //this.addAttributeBox(i, this.model.get('attributes')[i]);
				var attrName = this.model.get('attributes')[i];
				var attrNameSlice = attrName.split(":");
				if (attrNameSlice[1].trim() === "String"){
					this.addAttributeBox(i, attrNameSlice[0].substr(2));
				}else{
					this.addAttributeBox(i, attrName.substr(2));
				}
            }

            //add an extra empty one
            this.addAttributeBox(i);

            if (jQuery('#buttonPhotoReady').prop('checked')){
				jQuery('img#classIcon').css('visibility', 'hidden');
				jQuery('img.edit').css('visibility', 'hidden');
				jQuery('img.deleteAttr').css('visibility', 'hidden');
				jQuery('.attributInput input').prop('placeholder', '');
			}
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

        if (jQuery('#buttonPhotoReady').prop('checked')){
			jQuery('img#classIcon').css('visibility', 'hidden');
			jQuery('img.edit').css('visibility', 'hidden');
			jQuery('img.deleteMet').css('visibility', 'hidden');
			jQuery('.methodInput input').prop('placeholder', '');
		}
    },

    resetBoxsize: function () {
        //set box size
        var boxSize = this.model.get('size');
        boxSize['height'] = (this.$box.find('.classAttributes').children().length + this.$box.find('.classMethods').children().length) * 15 + 24;
        //boxSize['width'] = 50 + Math.floor(this.targetInputSize * 6.32);
        boxSize['width'] = 35 + Math.floor(this.targetInputSize * 6);
        this.model.set('size', boxSize);

        //set the position and dimension of the box so that it covers the JointJS element.
        var bbox = this.model.getBBox();

        this.$box.css({
            width: bbox.width,
            height: bbox.height,
            left: bbox.x,
            top: bbox.y,
            transform: 'rotate(' + (this.model.get('angle') || 0) + 'deg)'
        });

        var widthScale = bbox.width/100;
        var heightScale = bbox.height/60;

        //Dynamically set scale and translate of joint.js shape
        var jointShape = jQuery("#" + this.id);
        var xTranslate = bbox.x - 100;
        var yTranslate = bbox.y - 50;
        if (jointShape.children().length > 0){
			var rectScale = jQuery(jointShape.children().children());
			rectScale.attr({"transform": "scale("+ widthScale + "," + heightScale +")"})
			jointShape.attr({"transform": "translate("+ xTranslate + "," + yTranslate +")"})
        }

    }
});