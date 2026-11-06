#!/usr/bin/env python
# coding: utf-8

# In[1]:


# Constraint-based Scheduling (CSP) Problem: Tree Decomposition and Backtracking

class ConstraintBasedScheduling:
    def __init__(self, tasks, constraints):
        self.tasks = tasks
        self.constraints = constraints

    def is_consistent(self, assignment):
        # Check if the assignment satisfies all constraints
        for task1, task2 in self.constraints:
            if task1 in assignment and task2 in assignment:
                if assignment[task1] == assignment[task2]:
                    return False
        return True

    def backtracking_search(self, assignment={}):
        if len(assignment) == len(self.tasks):
            return assignment

        unassigned_task = next(task for task in self.tasks if task not in assignment)
        for value in range(1, len(self.tasks) + 1):
            assignment[unassigned_task] = value
            if self.is_consistent(assignment):
                result = self.backtracking_search(assignment)
                if result:
                    return result
            del assignment[unassigned_task]

        return None

# Example usage
if __name__ == '__main__':
    tasks = ['A', 'B', 'C', 'D']
    constraints = [('A', 'B'), ('B', 'C'), ('C', 'D')]

    csp = ConstraintBasedScheduling(tasks, constraints)
    solution = csp.backtracking_search()

    if solution:
        print("Solution found:")
        for task, value in solution.items():
            print(f"{task}: {value}")
    else:
        print("No solution exists.")


# In[ ]:




