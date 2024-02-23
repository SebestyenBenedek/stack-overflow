import React from 'react';
import ReactDOM from 'react-dom/client';
import { createBrowserRouter, createRoutesFromElements, Route, RouterProvider } from "react-router-dom";
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
import UserAnswerList from "./pages/UserAnswerList";

const router = createBrowserRouter(createRoutesFromElements(
    <Route /*errorElement={<ErrorPage />}*/>
        <Route path={'/'}>
            <Route index element={<HomePage />} />
        </Route>
        <Route path={'/login'}>
            <Route index element={<LoginPage />} />
        </Route>
        <Route path={'/registration'}>
            <Route index element={<RegistrationPage />} />
        </Route>
        <Route path={'/user'}>
            <Route index element={<UserPage />} />
            <Route path={'questions'} element={<UserQuestionList />} />
            <Route path={'answers'} element={<UserAnswerList />} />
        </Route>
        <Route path={'/questions'}>
            <Route index element={<QuestionList />}></Route>
            <Route path={'{id}'} element={<Question />}></Route>
            <Route path={'create'} element={<QuestionCreator />}></Route>
        </Route>
    </Route>
));

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
