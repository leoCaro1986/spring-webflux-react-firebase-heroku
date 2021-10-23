import React from 'react'
import { Link } from 'react-router-dom'

export const Question = ({ question, excerpt, onDelete, setCategorySearch }) => {


  const handleCategorySearch = (e)=>{
    setCategorySearch(question.category)
  }

  return <article className={excerpt ? 'question-excerpt' : 'question'}>
    <h5>Question:</h5> 
  <h2><div dangerouslySetInnerHTML={{__html:question.question}} /></h2>
  {setCategorySearch?
  <p className="categorySearch" onClick={handleCategorySearch}>Category: {question.category}<small></small></p>:
  <p>{question.category}  - <small>{question.type}</small></p>}

  {onDelete && (
    <button className="button right" onClick={() => onDelete(question.id)}>DELETE</button>
  )}
  {excerpt && (
    <Link to={`/question/${question.id}`} className="button ">
      View Question
    </Link>
  )}
</article>
}
