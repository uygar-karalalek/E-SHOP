package com.uygar.eshop.rest.controller.dto.mapper

import com.uygar.eshop.core.User
import com.uygar.eshop.rest.controller.dto.UserDto

object UserMapper {

    fun mapToDto(user: User): UserDto {
        return UserDto(
            user.id,
            user.name,
            user.surname,
            user.address,
            user.email,
            user.password,
            user.guest
        )
    }

    fun mapToDomain(userDto: UserDto): User {
        return User(
            userDto.id!!,
            userDto.name!!,
            userDto.surname!!,
            userDto.address!!,
            userDto.email!!,
            userDto.password!!,
            userDto.guest!!,
            userDto.orders!!.map(OrderMapper::mapToDomain).toMutableList()
        )
    }

}