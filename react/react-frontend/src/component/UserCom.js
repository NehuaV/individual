import React, { Component } from 'react';
import axios from 'axios';

class UserCom extends Component {

    constructor(props) {
        super(props)
    
        this.state = {
             posts : []
        }
    }


    
    
    
    componentDidMount() {
        axios.get('http://localhost:8080/users')
        .then(response =>{
            this.setState({
                posts: response.data
            })
            console.log(response.data)
        })
    }

    render() {
        const {posts} = this.state
        return(
            <div>
                <h1>List Of Users</h1>
                {
                    posts.map(post => <div key={post.userId}>{post.userId} {post.username} {post.email} {post.password}</div>)
                }
            </div>
        )
    }
}

export default UserCom