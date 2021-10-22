import React, { useState } from 'react'
import firebase from "firebase/app";

import "firebase/auth";
import swal from 'sweetalert';
import { Link } from 'react-router-dom';
import "firebase/firestore";
import {login} from "../actions/authActions"
import { useAuthState } from 'react-firebase-hooks/auth';

firebase.initializeApp({
	apiKey: "AIzaSyCOTYcOr_9C3-C0QUpJ3YbiCN6zie3l1YM",
	authDomain: "answer-and-question-dd046.firebaseapp.com",
	projectId: "answer-and-question-dd046",
	storageBucket: "answer-and-question-dd046.appspot.com",
	messagingSenderId: "128699813117",
	appId: "1:128699813117:web:57ba1abc86f8c72ba98294"
  });

const auth = firebase.auth();

export default function LoginPage({dispatch}) {



    const [email,setEmail] = useState('');
    const [password,setPassword] = useState('');

    const registrarUser = (e)=>{
        e.preventDefault()
        auth.signInWithEmailAndPassword(email, password)
        .then((res) => swal({
            icon: 'succes',
            title: 'Wellcome',
            text: 'Now enter',
        }))
    }

    
    	const signInWithGoogle = () => {
          const provider = new firebase.auth.GoogleAuthProvider();
          auth.signInWithPopup(provider);
        };

	const [user] = useAuthState(auth);
    if(user){
        dispatch(login(user.email, user.uid))
    }
        
      

    return (
        <div>
             <form
				className="mt-5 py-5 px-5"
				autoComplete="off"
                onSubmit={registrarUser}
				>
					<p className="lead">Enter your email and password here.</p>
					<div className="form-group">
						<input
							className="form-control"
							placeholder="Email"
							name="email"
							type="email"
							onChange={(e)=>{setEmail(e.target.value)}}
						></input>
					</div>
					<div className="form-group">
					<input
						className="form-control"
						placeholder="Password"
						name="password"
						type="password"
						onChange={(e)=>{setPassword(e.target.value)}}
						></input>
					</div>
            <div className="form-group">
              <button className="btn btn-dark px-5" onClick={registrarUser} value="register" type="submit">Sign in</button>
            </div>
            <br/>
			<br/>
					<p><h6>Click here to continue with Google</h6></p>
          	<button className="btn btn-dark px-5" onClick={signInWithGoogle}>
            		Sign In With Google
          	</button>
			  <br/>
			<br/>
			  <Link to="/register"><p><h6>You do not have an account? </h6>register</p></Link>
					<hr />
			</form>
        </div>
    )
}
