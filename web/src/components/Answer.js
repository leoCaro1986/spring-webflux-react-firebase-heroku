import React from 'react'

export const Answer = ({ answer, userId, onDelete}) => (
  <aside className="answer">
    <p>{answer.answer}</p>
    {answer.userId === userId&&<button onClick={() => onDelete(answer.id)}>Delete</button>}
  </aside>
)
