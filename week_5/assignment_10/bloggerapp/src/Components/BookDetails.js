import React from 'react';

function BookDetails() {
    const books = [
        { title: "The Great Gatsby", author: "F. Scott Fitzgerald", year: 1925 },
        { title: "To Kill a Mockingbird", author: "Harper Lee", year: 1960 },
        { title: "1984", author: "George Orwell", year: 1949 },
        { title: "Pride and Prejudice", author: "Jane Austen", year: 1813 },
    ];

    return (
        <div className="component-container">
            <h2>Book Details</h2>
            {books.length > 0 && (
                <ul>
                    {books.map((book, index) => (
                        <li key={index}>
                            <h3>{book.title}</h3>
                            <p>Author: {book.author}</p>
                            <p>Year: {book.year}</p>
                        </li>
                    ))}
                </ul>
            )}
        </div>
    );
}

export default BookDetails;
