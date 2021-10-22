import React, { useState } from 'react'
import firebase from "firebase/app";
import { auth } from '../App'
import "firebase/auth";
import swal from 'sweetalert';
import { Link } from 'react-router-dom';



export default function LoginPage() {



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
        
      

    return (
        <div>
             <form
				className="mt-5 py-5 px-5"
				autoComplete="off"
                onSubmit={registrarUser}
				/*onSubmit={this.handleSubmit}*/>
					<p className="lead">Enter your email and password here.</p>
					<div className="form-group">
						<input
						className="form-control"
						placeholder="Email"
						name="email"
						type="email"
						onChange={(e)=>{setEmail(e.target.value)}}
						/*value={this.state.email}*/></input>
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
