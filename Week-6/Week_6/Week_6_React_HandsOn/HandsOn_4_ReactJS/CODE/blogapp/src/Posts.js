import React, { Component } from 'react';
import Post from './Post';

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      hasError: false,
      errorMsg: ''
    };
  }

  async loadPosts() {
    try {
      const response = await fetch('https://jsonplaceholder.typicode.com/posts');
      if (!response.ok) throw new Error(`HTTP error ${response.status}`);
      const data = await response.json();
      const posts = data.map(post => new Post(post));
      this.setState({ posts });
    } catch (error) {
      this.setState({ hasError: true, errorMsg: error.message });
    }
  }

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    this.setState({ hasError: true, errorMsg: error.toString() });
  }

  render() {
    const { hasError, errorMsg, posts } = this.state;

    if (hasError) {
      return <div style={{ color: 'red' }}>Error: {errorMsg}</div>;
    }

    const topPosts = posts.slice(0, 10);

    return (
      <div>
        <h1>Blog Posts</h1>
        {posts.map(post => (
          <div key={post.id} style={{ marginBottom: '20px' }}>
            <h2>{post.title}</h2>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;
