import React from 'react';

function CourseDetails() {
    const courses = [
        { name: "Java Full Stack", duration: "6 months", level: "Advanced" },
        { name: "React for Beginners", duration: "3 months", level: "Beginner" },
        { name: "Python Programming", duration: "4 months", level: "Intermediate" },
    ];

    return (
        <div className="component-container">
            <h2>Course Details</h2>
            {courses.length > 0 ? (
                <ul>
                    {courses.map((course, index) => (
                        <li key={index}>
                            <h3>{course.name}</h3>
                            <p>Duration: {course.duration}</p>
                            <p>Level: {course.level}</p>
                        </li>
                    ))}
                </ul>
            ) : (
                <p>No courses available.</p>
            )}
        </div>
    );
}

export default CourseDetails;
