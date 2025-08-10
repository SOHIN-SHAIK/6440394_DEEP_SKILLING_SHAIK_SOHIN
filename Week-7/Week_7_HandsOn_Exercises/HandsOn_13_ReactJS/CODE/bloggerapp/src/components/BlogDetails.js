import React from 'react';

function BlogDetails({ show }) {
  return show ? (
    <div className="v1">
      <h1>Blog Details</h1>
      <p>Latest Blogs on Web Technologies...</p>
    </div>
  ) : null;
}

export default BlogDetails;
