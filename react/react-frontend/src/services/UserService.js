import axios from "axios";

const USERS_REST_API_URL = 'https://localhost:8080/users/user';

class UserService {

    getUsers(){
        axios.get(USERS_REST_API_URL);
    }
}

export default new UserService()