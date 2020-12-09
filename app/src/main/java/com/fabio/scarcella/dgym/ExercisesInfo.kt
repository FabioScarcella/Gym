package com.fabio.scarcella.dgym

import com.google.gson.annotations.SerializedName

class ExercisesInfo {
    var name: String? = null
    var videoURL: String? = null
    var textInformation: String? = null
    var Observations: String? = null

    constructor() : super() {}

    constructor(name: String, videoURL: String, textInformation: String, Observations: String) : super(){
        this.name = name
        this.videoURL = videoURL
        this.textInformation = textInformation
        this.Observations = Observations
    }
}