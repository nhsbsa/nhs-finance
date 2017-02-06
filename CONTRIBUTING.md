# Contributing

Pull requests are welcome.

## Git workflow

- Pull requests must contain a succinct, clear summary of what the user need is driving this feature change
- Follow our [Git styleguide](https://github.com/nhsuk/styleguides/blob/master/git.md)
- Make a feature branch
- Ensure your branch contains logical atomic commits before sending a pull request - follow our [Git styleguide](https://github.com/nhsuk/styleguides/blob/master/git.md)
- Pull requests are automatically tested, where applicable using [Gitlab CI](https://gitlab.com/), which will report back on whether the tests still pass on your branch
- You *may* rebase your branch after feedback if it's to include relevant updates from the master branch. We prefer a rebase here to a merge commit as we prefer a clean and straight history on master with discrete merge commits for features

## Code

- Must be readable with meaningful naming, eg no short hand single character variable names
- Follow our [styleguides](https://github.com/nhsuk/styleguides)

## Testing

Write tests.