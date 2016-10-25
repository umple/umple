var JJsParse = {
	addToArray: function (item) {
		arr = new Array();
		arr.push(item);
		return arr;
	},

	addAttributes: function (attrs) {
		// { "type" : "String", "name" : "startTime", "modifier" : "", "traceColor" : "black" }
		var i, text, attribute, max = attrs.length, attributes = new Array();
		for (i = 0; i < max; i++) {
			attribute = attrs[i];
			text = this.makeModifier(attribute.modifier) + " " + attribute.name + ": " + attribute.type;
			attributes.push(text);
		}
		return attributes;
	},

	addMethods: function(meths) {
		// {type: "void", name: "setDoorTimer", parameters: "Integer", visibility: "public", isAbstract: "false"}
		// console.log(meths);
		var i, text, method, max = meths.length, methods = new Array();
		for (i = 0; i < max; i++) {
			method = meths[i];
			text =  this.makeModifier(method.visibility) + " " + method.name + "(" + method.parameters + ") : " + method.type;
			methods.push(text);  
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

	makeClasses: function (model) {
		var i, text, UMLclass, max = model.umpleClasses.length, classes = new Array();
		var new_class;

		for (i = 0; i < max; i++) {
			UMLclass = model.umpleClasses[i];

			if (UMLclass.isAbstract == "true") {
				// console.log("made ABSTRACT class");
				new_class = new joint.shapes.uml.Abstract({
					position: UMLclass.position,
					size: UMLclass.position,
					name: this.addToArray(UMLclass.name),
					attributes: this.addAttributes(UMLclass.attributes),
					methods: this.addMethods(UMLclass.methods),
					id: UMLclass.id
				});
			}
			else if (UMLclass.isInterface  == "true") {
				// console.log("made INTERFACE class");
				new_class = new joint.shapes.uml.Interface({
					position: UMLclass.position,
					size: UMLclass.position,
					name: this.addToArray(UMLclass.name),
					attributes: this.addAttributes(UMLclass.attributes),
					methods: this.addMethods(UMLclass.methods),
					id: UMLclass.id
				});
			}
			else {
				// console.log("made reg class");
				new_class = new joint.shapes.uml.Class({
					position: UMLclass.position,
					size: UMLclass.position,
					name: this.addToArray(UMLclass.name),
					attributes: this.addAttributes(UMLclass.attributes),
					methods: this.addMethods(UMLclass.methods),
					id: UMLclass.id
				});
			}

			classes.push(new_class);
			// console.log(new_class);
		}

		return classes;
	}
};
