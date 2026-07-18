import React from 'react';

function BlogDetails() {
    const blogs = [
        { title: "React Hooks Guide", author: "Jane Doe", date: "2025-06-15" },
        { title: "CSS Grid Layout", author: "John Smith", date: "2025-06-10" },
        { title: "JavaScript ES6 Features", author: "Alice Johnson", date: "2025-06-05" },
    ];

    return (
        <div className="component-container">
            <h2>Blog Details</h2>
            {blogs.map((blog, index) => (
                <div key={index}>
                    <h3>{blog.title}</h3>
                    <p>Author: {blog.author}</p>
                    <p>Date: {blog.date}</p>
                </div>
            ))}
        </div>
    );
}

export default BlogDetails;
