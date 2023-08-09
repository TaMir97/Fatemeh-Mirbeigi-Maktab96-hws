#!/bin/bash
function create_five_txt_files() {
    for ((i = 1; i <= 5; i++)); do
        filename="file$i.txt"
        touch "$filename"
    done
    echo "Five text files (file1.txt to file5.txt) created successfully."
}

function add_text_to_files() {
    echo "Enter the text you want to add to the files:"
    # shellcheck disable=SC2162
    read input_text

    for ((i = 1; i <= 5; i++)); do
        filename="file$i.txt"
        echo "$input_text" >> "$filename"
    done

    echo "Text added successfully to files (file1.txt to file5.txt)."
}

function replace_text_in_files() {
    echo "Enter the text you want to replace:"
    # shellcheck disable=SC2162
    read search_text

    echo "Enter the text you want to replace it with:"
    # shellcheck disable=SC2162
    read replace_text

    for ((i = 1; i <= 5; i++)); do
        filename="file$i.txt"
        sed -i "s/${search_text}/${replace_text}/g" "$filename"
    done

    echo "Text replaced successfully in files (file1.txt to file5.txt)."
}
function display() {
    echo "Select an option:"
            options=("Create 5 text files"
                     "Add desired text to each"
                     "Remove a word and replace it"
                     "Quit")
}

function menu() {

    select choice in "${options[@]}"; do

        case "$choice" in
            "Create 5 text files")
                echo "You chose Option 1: Create 5 text files."
                create_five_txt_files
                break
                ;;
            "Add desired text to each")
                echo "You chose Option 2: Add desired text to each."
                add_text_to_files
                break
                ;;
            "Remove a word and replace it")
                echo "You chose Option 3: Remove a word and replace it."
                replace_text_in_files
                break
                ;;
            "Quit")
                exit 0
                ;;
            *)
                echo "Invalid choice. Please enter a number from 1 to 4."
                break
                ;;
        esac
    done
}


while true; do
    display
    menu
done
