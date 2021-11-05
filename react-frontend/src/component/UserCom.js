import React, { Component } from "react";
import axios from "axios";
import "../css/UserCom.css";
import { Table } from "reactstrap";

class UserCom extends Component {
  constructor(props) {
    super(props);

    this.state = {
      posts: [],
    };
  }

  componentDidMount() {
    axios.get("http://localhost:8080/users").then((response) => {
      this.setState({
        posts: response.data,
      });
      console.log(response.data);
    });
  }

  render() {
    const { posts } = this.state;
    return (
      <div>
        <h1>List Of Users</h1>
        <div className="table-container">
          <Table>
            <thead>
              <tr className="top-row">
                <th>UserID</th>
                <th>Username</th>
                <th>Email</th>
                <th>Password</th>
              </tr>
            </thead>
            <thead>
            {posts.map((post) => (
              <tr>
                <td>{post.userId}</td>
                <td>{post.username}</td>
                <td>{post.email}</td>
                <td>{post.password}</td>
              </tr>
            ))}
            </thead>
          </Table>
        </div>
      </div>
    );
  }
}

export default UserCom;
