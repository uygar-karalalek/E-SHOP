package com.uygar.eshop.persistence.entities.mapper

import com.uygar.eshop.core.User as UserDomain
import com.uygar.eshop.persistence.entities.User

object UserMapper {

    fun mapToEntity(user: UserDomain): User {
        return User(
            user.id,
            user.name,
            user.surname,
            user.address,
            user.email,
            user.password,
            ShoppingCardMapper.mapToEntity(user.shoppingCard)
        )
    }

    fun mapToDomain(userEntity: User): UserDomain {
        return UserDomain(
            userEntity.id,
            userEntity.name,
            userEntity.surname,
            userEntity.address,
            userEntity.email,
            userEntity.password,
            ShoppingCardMapper.mapToDomain(userEntity.shoppingCard)
        )
    }

}