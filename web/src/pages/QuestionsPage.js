import React, { useEffect, useState } from 'react'
import { connect } from 'react-redux'

import { fetchQuestions } from '../actions/questionActions'
import { Question } from '../components/Question'
import { Link } from 'react-router-dom'

const QuestionsPage = ({ dispatch, loading, questions, hasErrors }) => {
    useEffect(() => {
        dispatch(fetchQuestions())
    }, [dispatch])

    const [search, setSearch] = useState('');
    const [categorySearch, setCategorySearch] = useState('');

    const questionFilteredCategory = questions.filter(question => question.category.toUpperCase().includes(categorySearch.toUpperCase()))

    const questionsFilteredSearch = questionFilteredCategory.filter(question => question.question.toUpperCase().includes(search.toUpperCase()))

    const goTOVariable = questionsFilteredSearch[0]?.id
    //const questionDirected = questionsFilteredSearch[0]?.question
    


    const handleSearch =(e)=>{
        setSearch(e.target.value);
    }
     
    const renderQuestions = () => {
        if (loading) return <p>Loading questions...</p>
        if (hasErrors) return <p>Unable to display questions.</p>

        return questionsFilteredSearch.map(question => <Question setCategorySearch={setCategorySearch}
             key={question.id} 
             question={question} excerpt />)
    }

    return (
        <section className="page-section">
            <h1>Questions</h1>
            <form>
                <input type="text" onChange={handleSearch}/>
                <Link to={`/question/${goTOVariable}`} ><input style={{display: 'none'}} type="submit" value="search" /></Link>
            </form>
            {renderQuestions()}
        </section>
    )
}

const mapStateToProps = state => ({
    loading: state.question.loading,
    questions: state.question.questions,
    hasErrors: state.question.hasErrors,
})

export default connect(mapStateToProps)(QuestionsPage)
