with open("day4.txt", "r") as file:
    contents = file.read()
    sections = contents.split("\n\n")
    numbers = [int(num) for num in sections[0].split(",")]
    boards_raw = sections[1:]
    boards = []
    for board_raw in boards_raw:
        rows_raw = board_raw.split("\n")
        board = []
        for row_raw in rows_raw:
            row = [int(num) for num in row_raw.split()]
            board.append(row)
        boards.append(board)

def play_game(numbers, boards):
    cols = len(boards[0][0])
    rows = len(boards[0])

    all_num_signed = []
    for board in boards:
        num_marked = [
            [0] * rows,
            [0] * cols
        ]
        
        all_num_signed.append(num_marked)

    #pasquale hint set -1
    winning_board_indexes = []
    winning_nums = []
    for number in numbers:
        for i, board in enumerate(boards):
            if i in winning_board_indexes:
                continue
            num_marked = all_num_signed[i]
            for j, row in enumerate(board):
                try:
                    k = row.index(number)
                except ValueError:
                    continue
                board[j][k] = -1
                num_marked[0][j] += 1
                num_marked[1][k] += 1
            if rows in num_marked[0] or cols in num_marked[1]:
                winning_board_indexes.append(i)
                winning_nums.append(number)
    return (winning_board_indexes, winning_nums)

def calculate_left_nums_sum(board):
    left_nums_sum = 0
    for row in board:
        for num in row:
            if num > -1:
                left_nums_sum += num
    return left_nums_sum

# Part 1
winning_board_indexes, winning_nums = play_game(numbers, boards)
first_winning_board_index = winning_board_indexes[0]
winning_board = boards[first_winning_board_index]
left_numbers_sum = calculate_left_nums_sum(winning_board)
score = left_numbers_sum * winning_nums[0]
print("Part1:", score)

# Part 2
last_winning_board_index = winning_board_indexes[-1]
winning_board = boards[last_winning_board_index]
left_nums_sum = calculate_left_nums_sum(winning_board)
score = left_nums_sum * winning_nums[-1]
print("Part2:", score)