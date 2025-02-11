import React from "react";
import { connect } from "react-redux";
import { postReview } from "../actions/questionActions";

import { useForm } from "react-hook-form";
import Rating from "./Rating";

function QuestionReviewForm({ question, user, dispatch, loading, hasErrors }) {
  const { register, handleSubmit } = useForm();

  const onSubmit = (data) => {
    dispatch(postReview(data.review, question.id, user));
  };

  const renderQuestions = () => {
    console.log(question.userReviews);
    return question.userReviews?.includes(user);
  };
  if (loading) return <p>Loading ...</p>;
  if (hasErrors) return <p>Unable to display questions.</p>;

  return (
    <section>
      
      {renderQuestions() || user === null ? (
        <div>
           <p style={{display: 'inline-block'}}> Average question rating: </p>  <Rating question={question} />
        </div>
      ) : (
        <form className="form-rating form-control border-" onSubmit={handleSubmit(onSubmit)}>
          <label htmlFor="review">Question rating</label>
          <div className="row g-4 align-items-right">
            <div className="col-auto">
              <select className="form-rating" {...register("review")} id="">
                <option value=""> Select...</option>
                <option value="1">{`\u{1f641}`}</option>
                <option value="2"> {`\u{1f610}`}</option>
                <option value="3"> {`\u{1f600}`}</option>
              </select>
              <button  type="submit" className="button ">Rate question</button>
            </div>
          </div>
        </form>
      )}
    </section>
  );
}

const mapStateToProps = (state) => ({
  loading: state.question.loading,
  hasErrors: state.question.hasErrors,
  question: state.question.question,
  user: state.auth.uid,
});

export default connect(mapStateToProps)(QuestionReviewForm);