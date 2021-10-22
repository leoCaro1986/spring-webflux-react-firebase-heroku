import React, { useState } from 'react'
import firebase from "firebase/app";
import { auth } from '../App'
import "firebase/auth";
import swal from 'sweetalert';



export default function Register() {



    const [email,setEmail] = useState('');
    const [password,setPassword] = useState('');

    const registrarUser = (e)=>{
        e.preventDefault()
        auth.createUserWithEmailAndPassword(email, password)
        .then((res) => swal({
            icon: 'succes',
            title: 'Ususarioregistrado',
            text: 'Gracias por registrarse',
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
						/*value={this.state.password}*/></input>
					</div>
            <div className="form-group">
              <button className="btn btn-dark px-5" onClick={registrarUser} value="register" type="submit">Sign in</button>
            </div>
            <br/>
					<p>Click here to continue with Google</p>
          	<button className="btn btn-dark px-5" onClick={signInWithGoogle}>
            	Sign In With Google
          	</button>
					<hr />
				</form>
        </div>
    )
}