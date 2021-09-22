$(function() {

    $('.datatable tr').each(function(itself, row) {
        row = $(row);
        row.click(function() {
            // Remove the class from the previously selected row
            $('.selected-row').removeClass('.selected-row');

            ToggleForms(row);
            row.toggleClass('selected-row');
        });
    });

});

function ToggleForms(row) {
    const form = $('#question-form');
    const addForm = $('.add-form');

    addForm.toggleClass('hide');
    $('.edit-form').toggleClass('hide');

    if (addForm.hasClass('hide')) {
        // Edit Question Form
        form.attr('action', '/edit-question');
        UpdateQuestionForm(row);
    }
    else {
        // Add Question Form
        form.attr('action', '/add-question');
        ClearQuestionForm();
    }


}

function UpdateQuestionForm(row) {
    $('#id').text(row.children()[0].getInnerHTML());
    //$('#topicId').select(row.children()[1].getInnerHTML());
    $('#question').val(row.children()[2].getInnerHtml());
}

function ClearQuestionForm() {
    $('#id').text('This is automatically generated');
    //$('#topicId').select(1);
    $('#question').val('');
    $('#answer').val('');
    $('#optionB').val('');
    $('#optionC').val('');
    $('#optionD').val('');
}