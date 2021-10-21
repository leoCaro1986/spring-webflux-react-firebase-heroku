import React from 'react'
import { Link } from 'react-router-dom'

export const PublicNavbar = () => (
  <nav>
    <img src ="/icons8-question-64.png" alt="icon" style={{maxWidth:50, padding:0}} />
    <section>
      <Link to="/">Home</Link>
      <Link to="/questions">Questions</Link>
      <Link to="/LoginPage">Login</Link>
    </section>
  </nav>
)

export const PrivateNavbar = () => (
  <nav>
    <section>
      <link rel="icons8-questions"/>
      <Link to="/">Home</Link>
      <Link to="/questions">Questions</Link>
      <Link to="/new">New</Link>
      <Link to="/list">List</Link>
    </section>
  </nav>
)
