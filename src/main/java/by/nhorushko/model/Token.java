package by.nhorushko.model;

public enum Token {
    LOAD("Load existing database from file"),
    CREATE("Create new database"),
    EXIT("Exit program"),
    ADD("Add a new student"),
    REMOVE("Remove a student"),
    ALL("View all students' grades"),
    ADD_GRADES("add student grades"),
    UPDATE_GRADE("Update a student's grade"),
    REMOVE_GRADE("Remove a student's grade"),
    VIEW("View a specific student's grades"),
    SAVE("Save database to file"),
    MAIN("Return to main menu");

    private final String description;

    Token(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
