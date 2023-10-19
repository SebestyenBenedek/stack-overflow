import React from 'react';
import ReactDOM from 'react-dom/client';
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import './index.css';
import HomePage from './pages/HomePage/HomePage';
import reportWebVitals from './reportWebVitals';
import UserPage from "./pages/UserPage/UserPage";
import LoginPage from "./pages/LoginPage/LoginPage";
import QuestionList from "./components/QuestionList/QuestionList";
import QuestionCreator from "./pages/QuestionCreator";
import Question from "./components/Question/Question";
import RegistrationPage from "./pages/RegistrationPage/RegistrationPage";
import UserQuestionList from "./pages/UserQuestionList/UserQuestionList";

const router = createBrowserRouter([
    {
        path: "/",
        element: <HomePage/>,
    },
    {
        path: "/user",
        element: <UserPage />,
        children: [
            {
                path: "questions",
                element: <UserQuestionList />,
            }
            /*{
                path: "answers",
                element: <UserAnswerList />,
            }*/
        ]
    },
    {
        path: "/registration",
        element: <RegistrationPage />,
    },
    {
        path: "/login",
        element: <LoginPage />,
    },
    {
        path: "/questions",
        element: <QuestionList />,
    },
    {
      path: "/questions/{id}",
      element: <Question />,
    },
    {
        path: "/questions/create",
        element: <QuestionCreator />,
    }
]);

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
      <RouterProvider router={router} />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
