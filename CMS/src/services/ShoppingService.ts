export class ShoppingService {

    getToken(): string {
        const tokenString = localStorage.getItem("token")
        if (tokenString != null && tokenString !== "") {
            let stringTokenJSON = JSON.parse(tokenString);
            const tokenObject = JSON.parse(stringTokenJSON)
            return tokenObject.token;
        }
        return ""
    }

    setToken(userToken: any) {
        localStorage.setItem("token", JSON.stringify(userToken))
    }



}