<!--
This file provides concise, repo-specific guidance for AI coding agents (Copilot / automation bots).
Keep it short and actionable. Update when new top-level components are added.
-->

# Copilot instructions — AI-poc

Goal: help an AI agent become productive quickly by pointing to the small, discoverable surface area in this repository.

- Repo snapshot (discoverable):
  - `README.md` — project placeholder (no app code).
  - `.github/workflows/github-actions-demo.yml` — example workflow that runs on push (contains `actions/checkout@v5` and a file-listing step).
  - `.github/workflows/github-actions-dc.yml` — present but empty; likely intended for future CI/CD steps.

- Big picture (what to know):
  - This repository currently contains no application source files or test suites. Primary artifacts are the two GitHub Actions workflows and the README.
  - The demo workflow (`.github/workflows/github-actions-demo.yml`) is an explicit example of how CI steps should be authored here: use `runs-on: ubuntu-latest`, invoke `actions/checkout@v5`, and prefer small, explicit steps.
  - The empty `github-actions-dc.yml` is a clear integration point — new CI/CD workflows should be created or merged into this file.

- Actionable rules for edits and PRs (concrete, repository-specific):
  1. Preserve the demo workflow pattern when adding CI: include an explicit checkout step and short, named steps. Example: the demo uses `ls ${{ github.workspace }}` to inspect the repository on the runner.
  2. Do not assume an existing language/framework; when you add source code, also add a minimal README update describing build and test commands for that component.
  3. If creating a new workflow, place it under `.github/workflows/` and trigger on both `push` and `pull_request` for the relevant branches (the repo's default branch is `main`).
  4. When adding runnable code, create a top-level `src/` (or language-specific layout) and a `tests/` directory. Add CI steps that install dependencies and run tests. Because none are present yet, be explicit in new files about how to run them locally.

- Developer workflow notes (discoverable / verifiable):
  - To trigger CI: push to `main` or open a PR. The demo workflow runs on `push` events.
  - The demo workflow demonstrates the canonical runner environment: `ubuntu-latest`. Follow that for cross-platform consistency unless you need Windows-specific tasks.

- Conventions & patterns found here (use these as defaults):
  - Workflows are YAML files in `.github/workflows/`. Use `actions/checkout@v5` as the checkout action (already used in demo).
  - Keep CI steps small and idempotent — the demo follows this by echoing single-purpose messages.

- Integration points / external dependencies (none found):
  - No package manifests, Dockerfiles, cloud infra, or external service keys are present. If you add integration (packages, infra), document exact versions and any required secrets in the README and in the new workflow's `env`/`secrets` sections.

- Quick examples (copyable patterns observed in repo):
  - Minimal checkout + list files step (from demo workflow):
    ```yaml
    - name: Check out repository code
      uses: actions/checkout@v5

    - name: List files in the repository
      run: |
        ls ${{ github.workspace }}
    ```

- When uncertain, ask for context before making large changes:
  - This repo currently has no source code; ask which language, build system, or target platform the user expects before scaffolding files or CI.

If anything in this file is unclear or you'd like me to expand examples (e.g., add a starter workflow for Node/Python/.NET), tell me which language and I'll add a tailored example and CI steps.
