import React from 'react';
import { Link } from "react-router-dom";

const ErrorPage = () => {
    return (
        <section className="section">
            <div className="container">
                <div className="hero is-bold">
                    <div className="hero-body">
                        <div className="container">
                            <h1 className="title has-text-danger">Oops!</h1>
                            <h2 className="subtitle">We couldn't find what you were looking for.</h2>
                            <article className="message is-danger">
                                <div className="message-header">
                                    <p>Details</p>
                                </div>
                                <div className="message-body has-text-black is-size-7">
                                    <p className="has-text-weight-bold">The page you're looking for doesn't seem to exist.</p>
                                    <p>Here are a few reasons why you might be seeing this page:</p>
                                    <div className="content">
                                        <ul>
                                            <li>The page might have been removed or the URL changed.</li>
                                            <li>There could be a typo in the URL.</li>
                                            <li>The page might be temporarily unavailable due to server issues.</li>
                                        </ul>
                                    </div>
                                    <p>What can you do?</p>
                                    <div className="content">
                                        <ul>
                                            <li>Check the URL for any typos.</li>
                                            <li>Use the search bar to find what you're looking for.</li>
                                            <li className="has-text-weight-bold">Return to the homepage</li>
                                        </ul>
                                    </div>
                                </div>
                            </article>
                            <Link to={"/"} className="button is-primary">Home</Link>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    );
};

export default ErrorPage;
