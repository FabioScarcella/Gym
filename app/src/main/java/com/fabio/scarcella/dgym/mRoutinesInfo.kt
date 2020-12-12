package com.fabio.scarcella.dgym

class mRoutinesInfo(
        val name: String,
        val exercises: List<String>,
        val reps: List<String>,
        val weight: List<String>,
        val series: List<String>
) {
    override fun toString(): String{
        return "Category: [name: ${this.name}, exercises: ${this.exercises}, reps: ${this.reps}, weight: ${this.weight}, series: ${this.series}]"
    }
}