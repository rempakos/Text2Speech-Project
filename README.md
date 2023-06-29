# Text-to-Speech Application Readme

This Java-based Text-to-Speech (TTS) application allows users to open, edit, save, and transform the contents of different file types into audio. It provides various features to customize audio parameters, record transformation actions, and replay them. Below are the user stories/use cases and their corresponding implementation timeline:

## User Stories/Use Cases

1. **Open File**: The application allows users to open different file types stored on disk, including Microsoft Word (.docx) and Excel (.xlsx) documents. It also supports files with encoded contents, including Atbash and Rot-132 encodings.

2. **Edit File**: Users can edit the contents of the opened file using the application.

3. **Save File**: Users can save the contents of the opened file back to disk. They can specify the format, encoding (if any), and filename for the saved file.

4. **Transform to Audio**: The application transforms the contents of the opened file into audio.

5. **Selective Audio Conversion**: Users can select a specific part of the file's contents (e.g., from line X to line Y) and transform only the selected portion to audio.

6. **Audio Parameter Tuning**: Users have control over audio parameters such as volume, speech rate, and pitch to customize the generated audio.

7. **Recording Operation**: Users can activate a recording operation that tracks a sequence of text-to-audio transformation actions/commands.

8. **Replay Recorded Actions**: The application allows users to replay the recorded sequence of actions.

9. **Deactivate Recording**: Users can deactivate the recording operation when no longer needed.

## Installation and Usage

1. Clone the repository to your local machine.

2. Import the project into your preferred Java IDE.

3. Build the project and resolve any dependencies if needed.

4. Run the application and follow the on-screen instructions to perform the desired actions based on the provided use cases.

## Dependencies

This application requires the following dependencies:

- [Apache POI](https://poi.apache.org/) for handling Microsoft Word and Excel documents.
- [FreeTTS](https://freetts.sourceforge.io/) for text-to-speech conversion.

Please ensure that these dependencies are properly configured in your project before running the application.

## Support and Contributions

If you encounter any issues or have suggestions for improvement, please feel free to raise an issue or submit a pull request on the project repository. Your contributions are welcome and appreciated.

## License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT). Feel free to use, modify, and distribute the code as per the terms of the license.
