import React from 'react';
import './App.css';
import BookDetails from './Components/BookDetails';
import BlogDetails from './Components/BlogDetails';
import CourseDetails from './Components/CourseDetails';

function App() {
  const [showBooks, setShowBooks] = React.useState(true);
  const [showBlogs, setShowBlogs] = React.useState(false);
  const [showCourses, setShowCourses] = React.useState(true);

  return (
    <div className="App">
      <h1>Blogger App</h1>

      <div className="controls">
        <label>
          <input type="checkbox" checked={showBooks} onChange={() => setShowBooks(!showBooks)} />
          Show Books
        </label>
        <label>
          <input type="checkbox" checked={showBlogs} onChange={() => setShowBlogs(!showBlogs)} />
          Show Blogs
        </label>
        <label>
          <input type="checkbox" checked={showCourses} onChange={() => setShowCourses(!showCourses)} />
          Show Courses
        </label>
      </div>

      {showBooks && <BookDetails />}

      {showBlogs ? <BlogDetails /> : <p className="hidden-msg">Blogs are hidden</p>}

      <div className={showCourses ? '' : 'hidden'}>
        <CourseDetails />
      </div>
    </div>
  );
}

export default App;
