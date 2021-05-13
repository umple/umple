// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Models associations in the graphical view of UmpleOnline

UmpleTransitionFactory = new Object();

UmpleTransitionFactory.create = function(data)
{
    var umpleTransition = new UmpleTransition();
    umpleTransition.id = data.id;
    umpleTransition.fromStateId = data.fromStateId;
    umpleTransition.toStateId = data.toStateId;
    umpleTransition.name = data.name;
    umpleTransition.eventName = data.eventName;
    return umpleTransition;
}

function UmpleTransition() {
    this.id = null;
    this.fromStatePosition = null;
    this.toStatePosition = null;
    this.fromStateId;
    this.toStateId;
    this.name = "";
    this.eventName = "";
    this.color = "black";

    this.setStates = function (fromStateId, toStateId) {
        this.fromStateId = fromStateId;
        this.toStateId = toStateId;
    }

    this.setDefaultEvent = function () {
        this.eventName = "event1";
    }

    this.setName = function (aName) {
        this.name = aName;
    }

    this.getName = function () {
        return this.name;
    }

    this.getElementId = function () {
        return this.id == null ? "newtransition" : this.id;
    }

    this.getState = function (index) {
        return index == 0 ? UmpleSystem.find(this.fromStateId) : UmpleSystem.find(this.toStateId);
    }

}

