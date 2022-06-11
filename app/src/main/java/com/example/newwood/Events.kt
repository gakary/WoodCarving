package com.example.newwood

import android.content.Intent

class Events {
    var userTitle = ""
    var userEvenType = ""
    var userContact = ""
    var userDate =""
    var userTime =""
    var location= ""
    var eventDescription=""

    constructor(userTitle:String,userEvenType:String,userContact:String,userDate:String,userTime:String,location:String,eventDescription:String){
        this.userTitle = userTitle
        this.userEvenType = userEvenType
        this.userContact = userContact
        this.userDate = userDate
        this.userTime = userTime
        this.location = location
        this.eventDescription = eventDescription
    }



}
