let addFormIdMessage;

$(function() {
    addFormIdMessage = $('#id').text();

    $('.data-row').each(function(itself, row) {
        row = $(row);
        row.click(function() {
            const selectedRow = $('.selected-row');
            const isSelectedRow = row.hasClass('selected-row');
            // Remove the class from the previously selected row
            selectedRow.removeClass('selected-row');

            if (!isSelectedRow) {
                if ($('.edit-form').hasClass('hide')) {
                    ToggleForms();
                }

                // If they've clicked on the selected row, they're unselecting the row so don't re-select it.
                row.addClass('selected-row');
                UpdateQuestionForm(row);
            }
            else if ($('.add-form').hasClass('hide')) {
                ToggleForms();
            }
        });
    });

});

function ToggleForms() {
    const form = $('#question-form');
    const addForm = $('.add-form');

    addForm.toggleClass('hide');
    $('.edit-form').toggleClass('hide');

    if (addForm.hasClass('hide')) {
        // Edit Question Form
        form.attr('action', '/edit-question');
    }
    else {
        // Add Question Form
        form.attr('action', '/add-question');
        ClearQuestionForm();
    }
}

function UpdateQuestionForm() {
    $('#id').text($('.selected-row td:nth-child(1)').text());
    $('#topicId').val($('.selected-row td:nth-child(2)').attr('data-value'));
    $('#question').val($('.selected-row td:nth-child(3)').text());
    $('#answer').val($('.selected-row td:nth-child(4)').text());
    $('#optionB').val($('.selected-row td:nth-child(5)').text());
    $('#optionC').val($('.selected-row td:nth-child(6)').text());
    $('#optionD').val($('.selected-row td:nth-child(7)').text());
}

function ClearQuestionForm() {
    $('#id').text(addFormIdMessage);
    $('#topicId').val(1);
    $('#question').val('');
    $('#answer').val('');
    $('#optionB').val('');
    $('#optionC').val('');
    $('#optionD').val('');
}