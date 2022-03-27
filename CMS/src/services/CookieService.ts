export class CookieService {

    getToken(): string {
        return localStorage.getItem("e_shop_token")
    }

    setToken(userToken: any) {
        localStorage.setItem("e_shop_token", JSON.stringify(userToken)
            .replace(/"/gi, ''))
    }

}