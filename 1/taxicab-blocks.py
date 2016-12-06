import re


def step(pos, heading, steps):
    """Navigate multiple steps, returning each visited
    position and a new heading"""

    visits = []

    for step in range(steps):
        if heading == 0:
            pos[1] += 1
        elif heading == 3:
            pos[0] += 1
        elif heading == 6:
            pos[1] -= 1
        elif heading == 9:
            pos[0] -= 1

        visits.append(pos[:])

    return visits


def turn(heading, direction):
    """Turn left or right, indicated by clock hands
    at 0, 3, 6 or 9"""
    if direction == "R":
        heading = (heading + 3) % 12
    else:
        heading = (heading - 3) % 12

    return heading


def print_result(pos):
    print "%s blocks away" % (abs(pos[0]) + abs(pos[1]))


def main():
    check_existing_visit = True

    # Input from challenge
    directions_str = "R5, R4, R2, L3, R1, R1, L4, L5, R3, L1, L1, R4, L2, R1, R4, R4, L2, L2, R4, L4, R1, R3, L3, L1, L2, R1, R5, L5, L1, L1, R3, R5, L1, R4, L5, R5, R1, L185, R4, L1, R51, R3, L2, R78, R1, L4, R188, R1, L5, R5, R2, R3, L5, R3, R4, L1, R2, R2, L4, L4, L5, R5, R4, L4, R2, L5, R2, L1, L4, R4, L4, R2, L3, L4, R2, L3, R3, R2, L2, L3, R4, R3, R1, L4, L2, L5, R4, R4, L1, R1, L5, L1, R3, R1, L2, R1, R1, R3, L4, L1, L3, R2, R4, R2, L2, R1, L5, R3, L3, R3, L1, R4, L3, L3, R4, L2, L1, L3, R2, R3, L2, L1, R4, L3, L5, L2, L4, R1, L4, L4, R3, R5, L4, L1, L1, R4, L2, R5, R1, R1, R2, R1, R5, L1, L3, L5, R2"
    # directions_str = "R8, R4, R4, R8"
    directions = re.split(",\s+", directions_str)

    # Cartesian grid: 
    # x (negative west, positive east)
    # y (negative south, positive north)
    pos = [0, 0]

    # Collection of pos
    all_visits = [pos[:]]

    # clock-wise, default to north
    heading = 0

    existing_visit = None

    for direction in directions:
        # take steps
        heading = turn(heading, direction[0])
        steps = int(direction[1:])
        visits_on_direction = step(pos, heading, steps)

        # check if already visited
        for visit_on_direction in visits_on_direction:
            if visit_on_direction in all_visits:
                existing_visit = visit_on_direction
                print existing_visit
                break

        # merge into existing steps
        all_visits.extend(visits_on_direction)

        if check_existing_visit and existing_visit:
            print_result(existing_visit)
            break

    if not check_existing_visit:
        print_result(all_visits[-1])

main()
