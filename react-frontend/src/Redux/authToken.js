import axios from "axios";

// Change the axios header so it automatically includes the jwt token for authorization reasons
export default function authToken(token) {
  if (token) {
    axios.defaults.headers.common["Authorization"] = `${token}`;
  } else delete axios.defaults.headers.common["Authorization"];
}
