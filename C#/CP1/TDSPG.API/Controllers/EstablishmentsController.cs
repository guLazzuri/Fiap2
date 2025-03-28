using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using TDSPG.API.Domain.Entity;
using TDSPG.API.Infrastructure.Context;
using TDSPG.API.Infrastructure.Persistence.Repositories;

namespace TDSPG.API.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class EstablishmentsController : ControllerBase
    {
        private readonly IRepository<Establishment> _establishmentRepository;

        public EstablishmentsController(IRepository<Establishment> establishmentRepository)
        {
            _establishmentRepository = establishmentRepository;
        }

        // GET: api/Establishments
        //select * from Establishments
        [HttpGet]
        public async Task<IEnumerable<Establishment>> GetEstablishments()
        {
            return await _establishmentRepository.GetAsync();
        }

        // GET: api/Establishments/5
        [HttpGet("{id}")]
        public async Task<ActionResult<Establishment>> GetEstablishment(Guid id)
        {
            var establishment = await _establishmentRepository.GetByIdAsync(id);

            if (establishment == null)
            {
                return NotFound();
            }

            return establishment;
        }

        // PUT: api/Establishments/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutEstablishment(Guid id, Establishment establishment)
        {
            if (id != establishment.EstablishmentId)
            {
                return BadRequest();
            }

            await _establishmentRepository.UpdateAsync(establishment);

            return NoContent();
        }

        // POST: api/Establishments
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<Establishment>> PostEstablishment(Establishment establishment)
        {
            //"insert into Establ values()";
            //"commit";

            await _establishmentRepository.AddAsync(establishment);

            return CreatedAtAction("GetEstablishment", new { id = establishment.EstablishmentId }, establishment);
        }

        // DELETE: api/Establishments/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteEstablishment(Guid id)
        {
            var establishment = await _establishmentRepository.GetByIdAsync(id);
            if (establishment == null)
            {
                return NotFound();
            }
            await _establishmentRepository.DeleteAsync(id);

            return NoContent();
        }
    }
}
