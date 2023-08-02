#!/bin/bash

done="done.txt"
undone="undone.txt"
deleted="deleted.txt"

# Create the file if it doesn't exist
touch "$done"
touch "$undone"
touch "$deleted"


function display_menu() {
    echo "Menu:"
    echo "1) Add new task"
    echo "2) Display undone tasks"
    echo "3) Remove an undone task and add it to done tasks"
    echo "4) Display done tasks"
    echo "5) Remove an undone task and add it to deleted tasks "
    echo "6) Display deleted tasks"
    echo "7) Search in each list (undone, done, deleted)"
    echo "8) Quit"
    echo
    echo "Enter your choice:"
}


function add_new_task() {
    echo "Enter the task you want to add to undone tasks:"
    # shellcheck disable=SC2162
    read task
    line_number=$(($(wc -l < "$undone") + 1))
    echo "$line_number. $task" >> "$undone"
    echo "Task added successfully."
}


function display() {
    local input_file="$1"
    echo "File contents:"
    echo "-------------------------"
    cat "$input_file"
    echo "-------------------------"
}

function done_undone_task() {
    # shellcheck disable=SC2162
    read line_number

    if ! [[ "$line_number" =~ ^[0-9]+$ ]]; then
        echo "Invalid input. Please enter a valid number."
        return 1
    fi

    local input_file="$1"
    local output_file="$2"

    total_lines=$(wc -l < "$input_file")
    if [ "$line_number" -lt 1 ] || [ "$line_number" -gt "$total_lines" ]; then
        echo "Invalid line number. Please enter a valid line number between 1 and $total_lines."
        return 1
    fi

    line_content=$(sed -n "${line_number}p" "$input_file")
    sed -i "${line_number}d" "$input_file"

    echo "$line_content" >> "$output_file"
    echo "Task $line_content is done."
}

function search_and_replace() {
    echo "Enter the desired list of tasks:"
    # shellcheck disable=SC2162
    read input_file

    echo "Enter the pattern to search for:"
    # shellcheck disable=SC2162
    read search_pattern

    echo "Enter the pattern to replace with:"
    # shellcheck disable=SC2162
    read replace_pattern

    sed -i "s/${search_pattern}/${replace_pattern}/g" "$input_file"
    echo "Search and replace completed in '$input_file'."
}


while true; do
    display_menu
    # shellcheck disable=SC2162
    read choice

    case $choice in
        1)
            add_new_task
            ;;
        2)
          display "$undone"
          ;;
        3)
            display "$undone"
            echo "Enter the line number to remove from the file:"
            done_undone_task "$undone" "$done"
            ;;
        4)
            display "$done"
            ;;
        5)
            display "$done"
            echo "Enter the line number to remove from the file:"
            done_undone_task "$done" "$deleted"
            ;;
        6)
            display "$deleted"
            ;;
        7)
          search_and_replace
          ;;
        8)
          break
          ;;
        *)
            echo "Invalid choice. Please try again."
            ;;
    esac
done
