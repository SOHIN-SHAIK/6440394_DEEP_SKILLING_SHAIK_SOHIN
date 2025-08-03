import React from 'react';
import './App.css';
import { books } from './data';
import { blogs } from './data';
import { courses } from './data';

function App() {
  return (
    <div className="container">
      <div className="column">
        <h2>Course Details</h2>
        {courses.map((c) => (
          <div key={c.id}>
            <h3>{c.cname}</h3>
            <p>{c.date}</p>
          </div>
        ))}
      </div>

      <div className="column">
        <h2>Book Details</h2>
        {books.map((b) => (
          <div key={b.id}>
            <h3>{b.bname}</h3>
            <p>{b.price}</p>
          </div>
        ))}
      </div>

      <div className="column">
        <h2>Blog Details</h2>
        {blogs.map((blog) => (
          <div key={blog.id}>
            <h3>{blog.title}</h3>
            <p><b>{blog.author}</b></p>
            <p>{blog.content}</p>
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;
