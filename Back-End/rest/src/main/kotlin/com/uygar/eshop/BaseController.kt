package com.uygar.eshop

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class BaseController {

    @RequestMapping(name = "/")
    fun index(): String = "index"

}