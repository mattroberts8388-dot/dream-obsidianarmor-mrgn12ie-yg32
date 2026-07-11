# Obsidian Armor

A Minecraft Fabric mod (1.20.1) that adds a full **Obsidian Armor** set:

- Smelt **Obsidian** blocks in a **Blast Furnace** to get **Obsidian Ingots**.
- Craft a full armor set (helmet, chestplate, leggings, boots) from the ingots.
- Wearing any piece grants **Fire Resistance** while worn.
- The armor is heavy — each piece **slows your movement**.

---

## How to get the mod .jar file — no Java needed!

You do **not** need to install Java or any developer tools. GitHub will build the
mod `.jar` for you, for free, using the included build workflow.

Follow these exact steps:

1. **Create a GitHub account** at https://github.com (free).
2. Click the **+** in the top-right → **New repository**. Give it any name and click
   **Create repository**.
3. On the new empty repository page, click the link that says
   **"uploading an existing file"**.
4. **Extract the ZIP** you downloaded (double-click it) so you have a normal folder.
5. **macOS users — IMPORTANT:** This project contains a hidden folder named
   `.github` that holds the build instructions. Finder hides folders that start
   with a dot. In Finder, press **Cmd + Shift + .** (period) to reveal hidden
   files. If you skip this step, the `.github` folder will NOT be uploaded, the
   build will never run, and you will never get a `.jar`.
6. Open the extracted folder. Select **ALL files and folders INSIDE it**
   (including the hidden `.github` folder, `src`, `build.gradle`,
   `gradle.properties`, `settings.gradle`, `README.md`, etc.).
   **Drag the CONTENTS into the GitHub upload page — do NOT drag the outer folder itself.**
7. Scroll down and click **Commit changes**.
8. Click the **Actions** tab at the top of your repository. You will see the
   **Build** workflow running.
9. Wait about **2 minutes** for it to finish (green checkmark).
10. Click the finished workflow run, scroll to **Artifacts**, and download
    **mod-jar**.
11. Unzip it and copy the `.jar` file into your `.minecraft/mods/` folder
    (create the `mods` folder if it doesn't exist). You must have
    **Fabric Loader** and **Fabric API** installed for Minecraft 1.20.1.

Launch Minecraft with the Fabric profile and enjoy your Obsidian Armor!

---

## macOS reminder

The `.github` folder is **invisible by default** in Finder. Press
**Cmd + Shift + .** before selecting files, or the workflow won't upload and no
`.jar` will ever be built.