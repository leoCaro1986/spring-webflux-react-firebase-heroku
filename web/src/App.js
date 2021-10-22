import React from 'react'
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Redirect,
} from 'react-router-dom'
import firebase from "firebase/app";
import "firebase/firestore";
import "firebase/auth";
import { login, logout } from './actions/authActions';

import { PublicNavbar, PrivateNavbar } from './components/Navbar'
import HomePage from './pages/HomePage'
import SingleQuestionPage from './pages/SingleQuestionPage'
import QuestionsPage from './pages/QuestionsPage'
import QuestionFormPage from './pages/QuestionFormPage'
import AnswerFormPage from './pages/AnswerFormPage'
import OwnerQuestionsPage from './pages/OwnerQuestionsPage'
import Register from './pages/RegisterPage'
import { useAuthState } from "react-firebase-hooks/auth";
import  Footer  from './components/Footer'
import LoginPage from './pages/LoginPage.js'



firebase.initializeApp({
  apiKey: "AIzaSyCOTYcOr_9C3-C0QUpJ3YbiCN6zie3l1YM",
  authDomain: "answer-and-question-dd046.firebaseapp.com",
  projectId: "answer-and-question-dd046",
  storageBucket: "answer-and-question-dd046.appspot.com",
  messagingSenderId: "128699813117",
  appId: "1:128699813117:web:57ba1abc86f8c72ba98294"
});

const auth = firebase.auth();

const App = ({ dispatch }) => {
  const [user] = useAuthState(auth);
  if(user){
    dispatch(login(user.email, user.uid))
  }
  return (
    <Router>
      {user ?
        <>
          <PrivateNavbar />
          <Switch>
            <Route exact path="/" component={() => {
              return <HomePage><SignOut dispatch={dispatch} /></HomePage>
            }} />
            <Route exact path="/questions" component={QuestionsPage} />
            <Route exact path="/question/:id" component={SingleQuestionPage} />
            <Route exact path="/list" component={OwnerQuestionsPage} />
            <Route exact path="/answer/:id" component={AnswerFormPage} />
            <Route exact path="/new" component={QuestionFormPage} />
            <Redirect to="/" />
          </Switch>
        </> :
        <>
          <PublicNavbar />
          <Switch>
            <Route exact path="/" component={() => {
              return <HomePage><SignIn dispatch={dispatch} /></HomePage>
            }} />
            <Route exact path="/questions" component={QuestionsPage} />
            <Route exact path="/question/:id" component={SingleQuestionPage} />
            <Route exact path="/answer/:id" component={AnswerFormPage} />
            <Route exact path="/LoginPage"
            component={() => {
              return (
                <LoginPage dispatch={dispatch}>
                  </LoginPage>
              );
            }}/>
            <Route exact path="/register"
            component={
             Register 
            }
            />
            <Redirect to="/" />
            
          </Switch>
        </>
      }
      <br/><br/><br/><br/>
      <Footer/>
    </Router>
  )
}


function SignIn() {
  const signInWithGoogle = () => {
    const provider = new firebase.auth.GoogleAuthProvider();
    auth.signInWithPopup(provider);
  };
  return <button className="button right" onClick={signInWithGoogle}>Sign in with google</button>;
}

function SignOut({ dispatch }) {
  return (
    auth.currentUser && (
      <button
        className="button right"
        onClick={() => {
          dispatch(logout())
          auth.signOut();
        }}
      >
        Sign out
      </button>
    )
  );
}


export default App
export {auth}
/*export {signInWithGoogle}*/
