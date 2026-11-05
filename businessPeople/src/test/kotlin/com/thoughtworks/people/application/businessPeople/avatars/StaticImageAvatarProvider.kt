package com.thoughtworks.people.application.businessPeople.avatars

import com.thoughtworks.people.businessPeople.AvatarProvider
import com.thoughtworks.people.businessPeople.Person

class StaticImageAvatarProvider: AvatarProvider {

    override fun createForPerson(person: Person) =
            "https://api.dicebear.com/10.x/bottts/svg?seed=not%20found"

}