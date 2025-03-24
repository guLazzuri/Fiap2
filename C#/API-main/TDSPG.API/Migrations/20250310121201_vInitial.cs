using System;
using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace TDSPG.API.Migrations
{
    /// <inheritdoc />
    public partial class vInitial : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Establishment",
                columns: table => new
                {
                    EstablishmentId = table.Column<Guid>(type: "RAW(16)", nullable: false),
                    Name = table.Column<string>(type: "NVARCHAR2(2000)", nullable: false),
                    Document = table.Column<string>(type: "NVARCHAR2(2000)", nullable: false),
                    Type = table.Column<int>(type: "NUMBER(10)", nullable: false),
                    UserCreated = table.Column<string>(type: "NVARCHAR2(2000)", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Establishment", x => x.EstablishmentId);
                });
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Establishment");
        }
    }
}
